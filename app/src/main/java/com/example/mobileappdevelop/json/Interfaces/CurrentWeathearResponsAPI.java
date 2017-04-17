package com.example.mobileappdevelop.json.Interfaces;

import com.example.mobileappdevelop.json.modelclass.CurrentWeather;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mobile App Develop on 4/17/2017.
 */

public interface CurrentWeathearResponsAPI {
    @GET("/data/2.5/weather?q=Dhaka&appid=8e3a5f8c16948a8c2c36fe44e9bb23ff")
    Call<CurrentWeather > getRespons();
}
