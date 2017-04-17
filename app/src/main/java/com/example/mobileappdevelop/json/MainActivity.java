package com.example.mobileappdevelop.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mobileappdevelop.json.Interfaces.CurrentWeathearResponsAPI;
import com.example.mobileappdevelop.json.modelclass.CurrentWeather;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    CurrentWeathearResponsAPI apiRespons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiRespons = retrofit.create(CurrentWeathearResponsAPI.class);

        Call<ArrayList<CurrentWeather>> arrayListCall = apiRespons.getRespons();



    }
}
