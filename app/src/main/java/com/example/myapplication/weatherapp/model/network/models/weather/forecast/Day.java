package com.example.myapplication.weatherapp.model.network.models.weather.forecast;

import com.example.myapplication.weatherapp.model.network.models.weather.current.Condition;
import com.google.gson.annotations.SerializedName;

public class Day {
    @SerializedName("maxtemp_c")
    private double maxTemperature;
    @SerializedName("mintemp_c")
    private double minTemperature;
    @SerializedName("condition")
    private Condition condition;

    public Day(double maxTemperature, double minTemperature, Condition condition) {
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.condition = condition;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
