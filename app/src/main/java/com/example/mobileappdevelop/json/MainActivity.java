package com.example.mobileappdevelop.json;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mobileappdevelop.json.FragementPageAdapter.PageAdapter;
import com.example.mobileappdevelop.json.Interfaces.CurrentWeathearResponsAPIService;
import com.example.mobileappdevelop.json.MenuService;
import com.example.mobileappdevelop.json.ModelClassCurrentWeather.CurrentWeatherMain;
import com.example.mobileappdevelop.json.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MenuService {

    private TextView tvText;
    private TabLayout tabs;
    private ViewPager mPager;
    private PageAdapter pageAdapter;
    public static String dataType="metric";

    /*private final String BASE_URL = "http://api.openweathermap.org";
    CurrentWeathearResponsAPIService apiRespons;
    public static CurrentWeatherMain currentWeatherMain;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = (TextView) findViewById(R.id.tvtemperature);
        tabs = (TabLayout) findViewById(R.id.tabs);
        mPager = (ViewPager) findViewById(R.id.mpager);

        pageAdapter = new PageAdapter(getSupportFragmentManager());

        mPager.setAdapter(pageAdapter);
        tabs.setupWithViewPager(mPager);

        //RequestForCurrentWeatherData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void getDataType(MenuItem item) {
        switch (item.getItemId()){
            case R.id.celsius:
                dataType = "metric";
                mPager.setAdapter(pageAdapter);
                tabs.setupWithViewPager(mPager);
                break;
            case R.id.fahrenheit:
                dataType = "imperial";
                mPager.setAdapter(pageAdapter);
                tabs.setupWithViewPager(mPager);
                break;
        }
    }


    @Override
    public String getType() {
        return dataType;
    }

    /*private void RequestForCurrentWeatherData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiRespons = retrofit.create(CurrentWeathearResponsAPIService.class);

        Call<CurrentWeatherMain> arrayListCall = apiRespons.getRespons("/data/2.5/weather?q=Dhaka&appid=8e3a5f8c16948a8c2c36fe44e9bb23ff");

        arrayListCall.enqueue(new Callback<CurrentWeatherMain>() {
            @Override
            public void onResponse(Call<CurrentWeatherMain> call, Response<CurrentWeatherMain> response) {
                if(response.code()==200){
                    currentWeatherMain = response.body();
                    tvText.setText(String.valueOf(currentWeatherMain.getMain().getTemp()));
                }else {
                    tvText.setText("Error from onRespons");
                }
            }

            @Override
            public void onFailure(Call<CurrentWeatherMain> call, Throwable t) {
                tvText.setText(t.getMessage());
            }
        });
    }*/
}
