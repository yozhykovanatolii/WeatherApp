package com.example.myapplication.weatherapp.di;

import com.example.myapplication.weatherapp.model.network.ApiPoint;
import com.example.myapplication.weatherapp.model.repository.WeatherRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;

@Module
@InstallIn(ViewModelComponent.class)
public class RepositoryModule {
    @Provides
    public WeatherRepository provideWeatherRepository(ApiPoint apiPoint){
        return new WeatherRepository(apiPoint);
    }
}
