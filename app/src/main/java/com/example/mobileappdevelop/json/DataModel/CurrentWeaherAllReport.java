package com.example.mobileappdevelop.json.DataModel;

import com.example.mobileappdevelop.json.ModelClassCurrentWeather.CurrentWeatherMain;
import com.google.gson.internal.Streams;

/**
 * Created by r3l0ad3d on 4/20/17.
 */

public class CurrentWeaherAllReport {
    protected String Cloud;
    protected String Temperature;
    protected String Temperature_Max;
    protected String Temperature_Mini;
    protected String Humidity;
    protected String Pressure;
    protected String Wind;
    protected String Direction;
    protected String SunSetTime;
    protected String SunRiseTime;

    public CurrentWeaherAllReport(CurrentWeatherMain currentWeather) {
        this.Convert(currentWeather);
    }

    private void Convert(CurrentWeatherMain currentWeather) {
        setCloud(String.valueOf(currentWeather.getClouds()));
        setTemperature(String.valueOf(currentWeather.getMain().getTemp()));
        setTemperature_Max(String.valueOf(currentWeather.getMain().getTempMax()));
        setTemperature_Mini(String.valueOf(currentWeather.getMain().getTempMin()));
        setHumidity(String.valueOf(currentWeather.getMain().getHumidity()));
        setPressure(String.valueOf(currentWeather.getMain().getPressure()));
        setWind(String.valueOf(currentWeather.getWind().getSpeed()));
        setDirection(String.valueOf(currentWeather.getWind().getDeg()));
        setSunRiseTime(String.valueOf(currentWeather.getSys().getSunrise()));
        setSunSetTime(String.valueOf(currentWeather.getSys().getSunset()));
    }

    public String getCloud() {
        return Cloud;
    }

    protected void setCloud(String cloud) {
        Cloud = cloud;
    }

    public String getTemperature() {
        return Temperature;
    }

    protected void setTemperature(String temperature) {
        Temperature = temperature;
    }

    public String getTemperature_Max() {
        return Temperature_Max;
    }

    protected void setTemperature_Max(String temperature_Max) {
        Temperature_Max = temperature_Max;
    }

    public String getTemperature_Mini() {
        return Temperature_Mini;
    }

    protected void setTemperature_Mini(String temperature_Mini) {
        Temperature_Mini = temperature_Mini;
    }

    public String getHumidity() {
        return Humidity;
    }

    protected void setHumidity(String humidity) {
        Humidity = humidity;
    }

    public String getPressure() {
        return Pressure;
    }

    protected void setPressure(String pressure) {
        Pressure = pressure;
    }

    public String getWind() {
        return Wind;
    }

    protected void setWind(String wind) {
        Wind = wind;
    }

    public String getDirection() {
        return Direction;
    }

    protected void setDirection(String direction) {
        Direction = direction;
    }

    public String getSunSetTime() {
        return SunSetTime;
    }

    protected void setSunSetTime(String sunSetTime) {
        SunSetTime = sunSetTime;
    }

    public String getSunRiseTime() {
        return SunRiseTime;
    }

    protected void setSunRiseTime(String sunRiseTime) {
        SunRiseTime = sunRiseTime;
    }
}
