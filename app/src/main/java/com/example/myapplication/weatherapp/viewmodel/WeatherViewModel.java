package com.example.myapplication.weatherapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.weatherapp.model.network.models.weather.Weather;
import com.example.myapplication.weatherapp.model.repository.WeatherRepository;

import javax.inject.Inject;

import dagger.hilt.android.HiltAndroidApp;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class WeatherViewModel extends ViewModel {
    private WeatherRepository repository;

    @Inject
    public WeatherViewModel(WeatherRepository repository){
        this.repository = repository;
    }

    public LiveData<Weather> getCityWeather(String nameCity){
        return repository.getCityWeather(nameCity);
    }
}
