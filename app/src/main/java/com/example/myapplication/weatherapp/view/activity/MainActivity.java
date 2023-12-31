package com.example.myapplication.weatherapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.weatherapp.R;
import com.example.myapplication.weatherapp.adapter.DateAdapter;
import com.example.myapplication.weatherapp.adapter.ForecastAdapter;
import com.example.myapplication.weatherapp.model.network.models.weather.Weather;
import com.example.myapplication.weatherapp.model.network.models.weather.forecast.ForecastDay;
import com.example.myapplication.weatherapp.receiver.InternetReceiver;
import com.example.myapplication.weatherapp.viewmodel.WeatherViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    WeatherViewModel viewModel;
    BroadcastReceiver broadcastReceiver;
    SearchView searchView;
    ForecastAdapter adapter;
    DateAdapter dateAdapter;
    ImageView iconWeather;
    TextView temperature, weatherText, location, date;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.searchView);
        viewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        dateAdapter = new DateAdapter();
        broadcastReceiver = new InternetReceiver();
        initSearchView();
        initComponents();
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    private void initComponents(){
        recyclerView = findViewById(R.id.recyclerView);
        iconWeather = findViewById(R.id.imageView3);
        temperature = findViewById(R.id.temperature);
        weatherText = findViewById(R.id.weatherText);
        location = findViewById(R.id.location);
        date = findViewById(R.id.date);
    }

    private void initSearchView(){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                initData(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void initData(String nameCity){
        viewModel.getCityWeather(nameCity).observe(this, weather -> {
            System.out.println(weather);
            initTextAndImage(weather);
            initRecyclerView(weather.getForecast().getForecastDays());
        });
    }

    private void initRecyclerView(ArrayList<ForecastDay> forecastDays){
        adapter = new ForecastAdapter(forecastDays);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void initTextAndImage(Weather weather){
        temperature.setText((int) weather.getCurrent().getTemperature() + "°C");
        weatherText.setText(weather.getCurrent().getCondition().getText());
        location.setText(weather.getLocation().getName() + ", " + weather.getLocation().getCountry());
        date.setText(dateAdapter.getCurrentDate(weather.getForecast().getForecastDays().get(0).getDate()));
        Picasso.get().load("https:" + weather.getCurrent().getCondition().getUrlIcon()).into(iconWeather);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }
}