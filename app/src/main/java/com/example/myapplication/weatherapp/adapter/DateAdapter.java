package com.example.myapplication.weatherapp.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateAdapter {
    private SimpleDateFormat simpleDateFormat;
    private Date date;

    public String getDayOfWeek(String dateText) {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            date = simpleDateFormat.parse(dateText);
            simpleDateFormat.applyPattern("EEE");
            return simpleDateFormat.format(date);
        }catch (ParseException e){
            e.printStackTrace();
            return "";
        }
    }

    public String getCurrentDate(String dateText){
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            date = simpleDateFormat.parse(dateText);
            simpleDateFormat.applyPattern("EEEE, dd, MMM");
            return simpleDateFormat.format(date);
        }catch (ParseException e){
            e.printStackTrace();
            return "";
        }
    }
}
