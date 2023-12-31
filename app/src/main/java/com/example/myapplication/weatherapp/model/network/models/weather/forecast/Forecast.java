package com.example.myapplication.weatherapp.model.network.models.weather.forecast;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Forecast {
    @SerializedName("forecastday")
    private ArrayList<ForecastDay> forecastDays;

    public Forecast(ArrayList<ForecastDay> forecastDays) {
        this.forecastDays = forecastDays;
    }

    public ArrayList<ForecastDay> getForecastDays() {
        return forecastDays;
    }

    public void setForecastDays(ArrayList<ForecastDay> forecastDays) {
        this.forecastDays = forecastDays;
    }
}
