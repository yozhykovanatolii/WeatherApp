package com.example.myapplication.weatherapp.model.network;

import com.example.myapplication.weatherapp.model.network.models.weather.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiPoint {
    @GET("/v1/forecast.json?key=f26aa3ad2baa4bae920101715240101&days=5")
    Call<Weather> getCityWeather(@Query("q") String nameCity);
}
