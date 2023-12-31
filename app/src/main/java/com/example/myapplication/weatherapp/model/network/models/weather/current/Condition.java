package com.example.myapplication.weatherapp.model.network.models.weather.current;

import com.google.gson.annotations.SerializedName;

public class Condition {
    private String text;
    @SerializedName("icon")
    private String urlIcon;

    public Condition(String text, String urlIcon) {
        this.text = text;
        this.urlIcon = urlIcon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrlIcon() {
        return urlIcon;
    }

    public void setUrlIcon(String urlIcon) {
        this.urlIcon = urlIcon;
    }
}
