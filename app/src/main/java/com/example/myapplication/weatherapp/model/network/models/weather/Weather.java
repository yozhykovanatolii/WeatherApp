package com.example.myapplication.weatherapp.model.network.models.weather;

import com.example.myapplication.weatherapp.model.network.models.city.Location;
import com.example.myapplication.weatherapp.model.network.models.weather.current.Current;
import com.example.myapplication.weatherapp.model.network.models.weather.forecast.Forecast;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Weather {
    private Location location;
    private Current current;
    private Forecast forecast;

    public Weather(Location location, Current current, Forecast forecast) {
        this.location = location;
        this.current = current;
        this.forecast = forecast;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
}
