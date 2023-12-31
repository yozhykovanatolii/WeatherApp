package com.example.myapplication.weatherapp.model.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.weatherapp.model.network.ApiPoint;
import com.example.myapplication.weatherapp.model.network.models.weather.Weather;

import java.util.Objects;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {
    private ApiPoint apiPoint;

    @Inject
    public WeatherRepository(ApiPoint apiPoint){
        this.apiPoint = apiPoint;
    }

    public LiveData<Weather> getCityWeather(String nameCity){
        MutableLiveData<Weather> weatherMutableLiveData = new MutableLiveData<>();
        apiPoint.getCityWeather(nameCity).enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(@NonNull Call<Weather> call, @NonNull Response<Weather> response) {
                if(response.isSuccessful() && response.body() != null){
                    weatherMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Weather> call, @NonNull Throwable t) {
                Log.i("Errors", Objects.requireNonNull(t.getMessage()));
            }
        });
        return weatherMutableLiveData;
    }
}
