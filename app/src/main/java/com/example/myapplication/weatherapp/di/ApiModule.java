package com.example.myapplication.weatherapp.di;

import com.example.myapplication.weatherapp.model.network.ApiPoint;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class ApiModule {
    @Singleton
    @Provides
    public ApiPoint provideApiPoint(){
        return new Retrofit.Builder()
                .baseUrl("http://api.weatherapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiPoint.class);
    }
}
