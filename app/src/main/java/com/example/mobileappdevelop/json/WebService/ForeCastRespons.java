package com.example.mobileappdevelop.json.WebService;

import com.example.mobileappdevelop.json.Interfaces.WeatherForeCastAPIService;
import com.example.mobileappdevelop.json.ModelClassForecast.WeatherForeCastMain;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by r3l0ad3d on 4/18/17.
 */

public class ForeCastRespons {
    private WeatherForeCastMain weatherForeCastData;
    private Retrofit retrofit;
    private WeatherForeCastAPIService foreCastAPIService;
    private static final String BASE_URL = "http://api.openweathermap.org/";

    private boolean flag;

    public void getRespons(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        foreCastAPIService = retrofit.create(WeatherForeCastAPIService.class);
        final Call<WeatherForeCastMain> getService = foreCastAPIService.getForeCastRespons();

        getService.enqueue(new Callback<WeatherForeCastMain>() {
            @Override
            public void onResponse(Call<WeatherForeCastMain> call, Response<WeatherForeCastMain> response) {
                if(response.code()==200){
                    WeatherForeCastMain weatherForeCastMain = response.body();
                    setWeatherForeCastData(weatherForeCastMain);
                    flag=true;
                }else flag = false;
            }

            @Override
            public void onFailure(Call<WeatherForeCastMain> call, Throwable t) {

            }
        });
    }

    public boolean isRespond(){
        if(flag) return true;
        else return false;
    }

    public WeatherForeCastMain getWeatherForeCastData() {
        return weatherForeCastData;
    }

    public void setWeatherForeCastData(WeatherForeCastMain weatherForeCastData) {
        this.weatherForeCastData = weatherForeCastData;
    }
}
