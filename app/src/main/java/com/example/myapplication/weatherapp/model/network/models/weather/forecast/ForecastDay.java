package com.example.myapplication.weatherapp.model.network.models.weather.forecast;

import com.google.gson.annotations.SerializedName;

public class ForecastDay {
    private String date;
    @SerializedName("day")
    private Day day;

    public ForecastDay(String date, Day day) {
        this.date = date;
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
