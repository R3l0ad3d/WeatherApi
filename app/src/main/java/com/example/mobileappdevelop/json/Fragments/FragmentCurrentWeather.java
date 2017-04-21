package com.example.mobileappdevelop.json.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobileappdevelop.json.DataModel.CurrentWeaherAllReport;
import com.example.mobileappdevelop.json.Interfaces.CurrentWeathearResponsAPIService;
import com.example.mobileappdevelop.json.MainActivity;
import com.example.mobileappdevelop.json.ModelClassCurrentWeather.CurrentWeatherMain;
import com.example.mobileappdevelop.json.R;
import com.example.mobileappdevelop.json.WebService.CurrentWeatherRespons;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCurrentWeather extends Fragment {

    private TextView pressureTV,humidityTV;
    private TextView temperatureTV,temperatureMaxTV,temperatureMiniTV;
    private TextView sunSetOrRiseTV,sunSetOrRiseDownTV,sunSetOrRiseTime,sunSetOrRiseTimeDown;
    private TextView windTV,directionTV,weatherReportTV,dateTV,locationTV;

    private ImageView weatherIconIV,sunSetOrRiseIconIV,humidityIconIV,windIconIV,directionIconIV;

    private final String BASE_URL = "http://api.openweathermap.org";
    private CurrentWeathearResponsAPIService apiRespons;

    public FragmentCurrentWeather() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_current_weather, container, false);

        locationTV = (TextView) view.findViewById(R.id.tvPlaceLocation);
        dateTV = (TextView) view.findViewById(R.id.tvTime);

        weatherReportTV = (TextView) view.findViewById(R.id.tvWeatherReport);

        //Temperature
        temperatureTV = (TextView) view.findViewById(R.id.tvTemperature);
        temperatureMaxTV = (TextView) view.findViewById(R.id.tvTemperatureMax);
        temperatureMiniTV = (TextView) view.findViewById(R.id.tvTemperatureMini);
        weatherIconIV = (ImageView) view.findViewById(R.id.ivWeatherIcon);

        //Sun set Sun Rise
        sunSetOrRiseTV = (TextView) view.findViewById(R.id.tvSunsetOrRise);
        sunSetOrRiseDownTV = (TextView) view.findViewById(R.id.tvSunsetOrRiseDown);
        sunSetOrRiseTime = (TextView) view.findViewById(R.id.tvSunSetRiseTime);
        sunSetOrRiseTimeDown = (TextView) view.findViewById(R.id.tvSunSetRiseTime);
        sunSetOrRiseIconIV = (ImageView) view.findViewById(R.id.ivSunSetRiseIcon);

        //Humidity
        humidityTV = (TextView) view.findViewById(R.id.tvHumidity);
        humidityIconIV = (ImageView) view.findViewById(R.id.ivHumidityIcon);

        //Wind
        windTV = (TextView) view.findViewById(R.id.tvWind);
        windIconIV = (ImageView) view.findViewById(R.id.ivWindIcon);

        //Direction
        directionTV = (TextView) view.findViewById(R.id.tvDirection);
        directionIconIV = (ImageView) view.findViewById(R.id.ivDirectionIcon);


        RequestForCurrentWeatherData();

        return view;
    }

    private void RequestForCurrentWeatherData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiRespons = retrofit.create(CurrentWeathearResponsAPIService.class);

        Call<CurrentWeatherMain> arrayListCall = apiRespons
                .getRespons("/data/2.5/weather?q=Dhaka&units=metric&appid=8e3a5f8c16948a8c2c36fe44e9bb23ff");

        arrayListCall.enqueue(new Callback<CurrentWeatherMain>() {
            @Override
            public void onResponse(Call<CurrentWeatherMain> call, Response<CurrentWeatherMain> response) {
                if(response.code()==200){
                    CurrentWeatherMain currentWeatherMain = response.body(); //error here nothing get from server
                    setData(currentWeatherMain);
                    Toast.makeText(getContext(),currentWeatherMain.getName(),Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getContext(),"Here is error form server side",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<CurrentWeatherMain> call, Throwable t) {
                //tvText.setText(t.getMessage());
            }
        });
    }

    private void setData(CurrentWeatherMain currentWeatherMain) {

        CurrentWeaherAllReport report = new CurrentWeaherAllReport(currentWeatherMain);

        //set Temperature
        temperatureTV.setText(report.getTemperature());
        temperatureMiniTV.setText(report.getTemperature_Mini());
        temperatureMaxTV.setText(report.getTemperature_Max());
        Picasso.with(getContext()).load("http://openweathermap.org/img/w/"+currentWeatherMain.getWeather().get(0).getIcon()+".png")
                .into(weatherIconIV);


        //pressureTV.setText(report.getPressure());
        humidityTV.setText(report.getHumidity());
        windTV.setText(report.getWind());
        directionTV.setText(report.getDirection());

        sunSetOrRiseTime.setText(report.getSunRiseTime());
        sunSetOrRiseTimeDown.setText(report.getSunSetTime());

        sunSetOrRiseIconIV.setImageResource(R.drawable.sunrise);
        windIconIV.setImageResource(R.drawable.wind);
        directionIconIV.setImageResource(R.drawable.direction);
        humidityIconIV.setImageResource(R.drawable.humidity);
    }

}
