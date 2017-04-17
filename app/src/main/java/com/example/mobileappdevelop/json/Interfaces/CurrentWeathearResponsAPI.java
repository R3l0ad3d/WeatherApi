package com.example.mobileappdevelop.json.Interfaces;

import com.example.mobileappdevelop.json.modelclass.CurrentWeather;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mobile App Develop on 4/17/2017.
 */

public interface CurrentWeathearResponsAPI {
    @GET("weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1")
    Call<ArrayList<CurrentWeather> > getRespons();
}
