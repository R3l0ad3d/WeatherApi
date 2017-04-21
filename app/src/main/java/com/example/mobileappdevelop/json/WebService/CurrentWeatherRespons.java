package com.example.mobileappdevelop.json.WebService;

import android.util.Log;

import com.example.mobileappdevelop.json.Interfaces.CurrentWeathearResponsAPIService;
import com.example.mobileappdevelop.json.ModelClassCurrentWeather.CurrentWeatherMain;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by r3l0ad3d on 4/18/17.
 */

public class CurrentWeatherRespons {
    private final String BASE_URL = "http://api.openweathermap.org";
    private CurrentWeathearResponsAPIService apiRespons;

    private CurrentWeatherMain weatherMain;

    private boolean flag;
/*

    public void getRespons(){
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
                    weatherMain = response.body();
                    flag = true;

                    Log.e("is Work","work................."+weatherMain.getDt().toString());
                }else {
                    flag = false;
                    Log.e("is Work","not work.................");
                }
            }

            @Override
            public void onFailure(Call<CurrentWeatherMain> call, Throwable t) {
                flag=false;
                Log.e("is Work",t.getMessage());
            }
        });
    }
*/

    public boolean isRespond(){
        if(flag) return true;
        else return false;
    }

    public CurrentWeatherMain getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(CurrentWeatherMain weatherMain) {
        this.weatherMain = weatherMain;
    }
}
