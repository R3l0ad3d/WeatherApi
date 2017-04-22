package com.example.mobileappdevelop.json.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobileappdevelop.json.Interfaces.WeatherForeCastAPIService;
import com.example.mobileappdevelop.json.ModelClassForecast.WeatherForeCastMain;
import com.example.mobileappdevelop.json.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentForeCase extends Fragment {

    private static final String BASE_URL = "http://api.openweathermap.org/";

    WeatherForeCastMain foreCastMain;

    private TextView tvTest;
    public FragmentForeCase() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment_fore_case, container, false);
        tvTest = (TextView) view.findViewById(R.id.tvTest);
        getRespons();

        return view;
    }

    private void getRespons(){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherForeCastAPIService apiService = retrofit.create(WeatherForeCastAPIService.class);
        Call<WeatherForeCastMain> foreCastMainCall = apiService.getForeCastRespons("data/2.5/forecast?q=Dhaka&units=metric&appid=8e3a5f8c16948a8c2c36fe44e9bb23ff");

        foreCastMainCall.enqueue(new Callback<WeatherForeCastMain>() {
            @Override
            public void onResponse(Call<WeatherForeCastMain> call, Response<WeatherForeCastMain> response) {
                if(response.code()==200){
                    WeatherForeCastMain data = response.body();
                    setData(data);
                }else{
                    tvTest.setText("Nothing Get From Respons");
                }
            }

            @Override
            public void onFailure(Call<WeatherForeCastMain> call, Throwable t) {
                tvTest.setText(t.getMessage());
            }
        });
    }

    private void setData(WeatherForeCastMain data) {
        tvTest.setText(String.valueOf(data.getList().get(0).getMain().getTemp()));
    }

}
