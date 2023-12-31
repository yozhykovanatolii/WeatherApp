package com.example.myapplication.weatherapp.model.network.models.weather.current;

import com.google.gson.annotations.SerializedName;

public class Current {
    @SerializedName("temp_c")
    private double temperature;
    @SerializedName("condition")
    private Condition condition;

    public Current(double temperature, Condition condition) {
        this.temperature = temperature;
        this.condition = condition;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
