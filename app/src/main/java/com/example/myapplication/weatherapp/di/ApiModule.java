package com.example.myapplication.weatherapp.di;

import com.example.myapplication.weatherapp.model.network.ApiPoint;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;

@Module
@InstallIn(SingletonComponent.class)
public class ApiModule {
    @Singleton
    @Provides
    public ApiPoint provideApiPoint(){
        return new Retrofit.Builder()
                .baseUrl("http://api.weatherapi.com")
                .build()
                .create(ApiPoint.class);
    }
}
