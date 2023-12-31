package com.example.myapplication.weatherapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.weatherapp.R;
import com.example.myapplication.weatherapp.model.network.models.weather.forecast.ForecastDay;
import com.squareup.picasso.Picasso;



import java.util.ArrayList;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {
    private ArrayList<ForecastDay> forecastDays;
    private DateAdapter dateAdapter = new DateAdapter();

    public ForecastAdapter(ArrayList<ForecastDay> forecastDays) {
        this.forecastDays = forecastDays;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ForecastDay forecastDay = forecastDays.get(position);
        Picasso.get().load("https:" + forecastDay.getDay().getCondition().getUrlIcon()).into(holder.iconWeather);
        holder.day.setText(dateAdapter.getDayOfWeek(forecastDay.getDate()));
        holder.weatherDescription.setText(forecastDay.getDay().getCondition().getText());
        holder.maxAndMinTemperature.setText((int) forecastDay.getDay().getMaxTemperature() + "°C" +
                " / " + (int) forecastDay.getDay().getMinTemperature() + "°C");
    }

    @Override
    public int getItemCount() {
        return forecastDays.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconWeather;
        TextView day, weatherDescription, maxAndMinTemperature;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconWeather = itemView.findViewById(R.id.iconWeather);
            day = itemView.findViewById(R.id.day);
            weatherDescription = itemView.findViewById(R.id.weatherDescription);
            maxAndMinTemperature = itemView.findViewById(R.id.maxAndMinTemperature);
        }
    }
}
