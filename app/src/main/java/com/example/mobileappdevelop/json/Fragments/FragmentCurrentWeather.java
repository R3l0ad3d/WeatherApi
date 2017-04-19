package com.example.mobileappdevelop.json.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobileappdevelop.json.Interfaces.CurrentWeathearResponsAPIService;
import com.example.mobileappdevelop.json.MainActivity;
import com.example.mobileappdevelop.json.ModelClassCurrentWeather.CurrentWeatherMain;
import com.example.mobileappdevelop.json.R;
import com.example.mobileappdevelop.json.WebService.CurrentWeatherRespons;

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
    private CurrentWeatherRespons currentWeatherRespons;
    //private CurrentWeatherMain currentWeatherMain;

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

        /*currentWeatherRespons = new CurrentWeatherRespons();
        currentWeatherRespons.getRespons();
        if(currentWeatherRespons.isRespond()){
            currentWeatherMain = currentWeatherRespons.getCurrentWeather();
            setData();
        }*/
        //currentWeatherMain = MainActivity.currentWeatherMain;

        RequestForCurrentWeatherData();

        return view;
    }

    private void RequestForCurrentWeatherData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiRespons = retrofit.create(CurrentWeathearResponsAPIService.class);

        Call<CurrentWeatherMain> arrayListCall = apiRespons.getRespons();

        arrayListCall.enqueue(new Callback<CurrentWeatherMain>() {
            @Override
            public void onResponse(Call<CurrentWeatherMain> call, Response<CurrentWeatherMain> response) {
                if(response.code()==200){
                    CurrentWeatherMain currentWeatherMain = response.body();
                    //tvText.setText(String.valueOf(currentWeatherMain.getMain().getTemp()));
                    setData(currentWeatherMain);
                }else {
                    //tvText.setText("Error from onRespons");
                }
            }

            @Override
            public void onFailure(Call<CurrentWeatherMain> call, Throwable t) {
                //tvText.setText(t.getMessage());
            }
        });
    }

    private void setData(CurrentWeatherMain currentWeatherMain) {
        //set Temperature
        temperatureTV.setText(String.valueOf(currentWeatherMain.getMain().getTemp()));
        temperatureMiniTV.setText(String.valueOf(currentWeatherMain.getMain().getTempMin()));
        temperatureMaxTV.setText(String.valueOf(currentWeatherMain.getMain().getTempMax()));

    }

}
