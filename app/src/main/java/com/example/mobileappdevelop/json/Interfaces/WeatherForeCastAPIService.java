package com.example.mobileappdevelop.json.Interfaces;

import com.example.mobileappdevelop.json.ModelClassForecast.WeatherForeCastMain;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by r3l0ad3d on 4/18/17.
 */

public interface WeatherForeCastAPIService {
    @GET("data/2.5/forecast?q=Dhaka&appid=8e3a5f8c16948a8c2c36fe44e9bb23ff")
    Call<WeatherForeCastMain> getForeCastRespons();
}
