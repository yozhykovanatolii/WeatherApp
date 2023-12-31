package com.example.myapplication.weatherapp.model.network;

import com.example.myapplication.weatherapp.model.network.models.weather.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiPoint {
    @GET("/v1/forecast.json?key=32b74ad09da5434fbac84545232907&days=5")
    Call<Weather> getCityWeather(@Query("q") String nameCity);
}
