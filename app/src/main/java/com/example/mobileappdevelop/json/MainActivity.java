package com.example.mobileappdevelop.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mobileappdevelop.json.Interfaces.CurrentWeathearResponsAPIService;
import com.example.mobileappdevelop.json.ModelClassCurrentWeather.CurrentWeatherMain;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView tvText;

    private final String BASE_URL = "http://api.openweathermap.org";
    CurrentWeathearResponsAPIService apiRespons;
    CurrentWeatherMain currentWeatherMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = (TextView) findViewById(R.id.tvtemperature);

        RequestForCurrentWeatherData();

        /*if(currentWeatherArrayList.size()>0){
            tvText.setText(String.valueOf(currentWeatherArrayList.get(0).getMain().getPressure()));
        }else {
            tvText.setText("Nothing found");
        }*/

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
                    currentWeatherMain = response.body();
                    tvText.setText(String.valueOf(currentWeatherMain.getMain().getPressure()));
                }else {
                    tvText.setText("Error from onRespons");
                }
            }

            @Override
            public void onFailure(Call<CurrentWeatherMain> call, Throwable t) {
                tvText.setText(t.getMessage());
            }
        });
    }
}
