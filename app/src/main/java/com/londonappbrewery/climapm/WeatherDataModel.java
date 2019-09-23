package com.londonappbrewery.climapm;

import android.util.Log;


import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class WeatherDataModel {

    // TODO: Declare the member variables here
    private String mTemparatureC;
    private String mTemparatureF;
    private int mCondition;
    private String mCity;
    private String mMinC;
    private String mMinF;
    private String mMaxC;
    private String mMaxF;
    private String mCountry;
    private String mSpeed;
    private String mHumidity;
    private String mDescription;
    private long mSunrise;

    // TODO: Create a WeatherDataModel from a JSON:


    public static WeatherDataModel fromJson (JSONObject jsonObject){
        WeatherDataModel weatherDataModel = new WeatherDataModel();

        try {
            weatherDataModel.mCity = jsonObject.getString("name");
            weatherDataModel.mCondition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherDataModel.mCountry = jsonObject.getJSONObject("sys").getString("country");
            weatherDataModel.mDescription = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
            weatherDataModel.mSunrise = jsonObject.getJSONObject("sys").getLong("sunrise");

            int minF = (int) Math.rint(jsonObject.getJSONObject("main").getDouble("temp_min") - 273.15);
            int minC = (int) Math.rint(minF * 9.0/5.0 + 32);
            weatherDataModel.mMinC = Integer.toString(minC);
            weatherDataModel.mMinF = Integer.toString(minF);
            int maxF =(int) Math.rint(jsonObject.getJSONObject("main").getDouble("temp_max") - 273.15);
            int maxC =(int) Math.rint(maxF * 9.0/5.0 + 32);
            weatherDataModel.mMaxC = Integer.toString(maxC);
            weatherDataModel.mMaxF = Integer.toString(maxF);

            double tempResult = jsonObject.getJSONObject("main").getDouble("temp") - 273.15;
            double tempFar = tempResult * 9.0 / 5.0 + 32;

            int tempCel = (int) Math.rint(tempResult);
            int tempFaren = (int) Math.rint(tempFar);

            weatherDataModel.mTemparatureC = Integer.toString(tempCel);
            weatherDataModel.mTemparatureF = Integer.toString(tempFaren);

            weatherDataModel.mSpeed = jsonObject.getJSONObject("wind").getString(String.valueOf("speed"));
            weatherDataModel.mHumidity = jsonObject.getJSONObject("main").getString(String.valueOf("humidity"));


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return weatherDataModel;
    }
    // TODO: Create getter methods for temperature, city, and icon name:

    public String getTemparatureC() {
        return mTemparatureC + "°";
    }

    public String getTemparatureF() {
        return mTemparatureF + "°";
    }

    public int getCondition() {
        return mCondition;
    }

    public String getCity() {
        return mCity;
    }

    public String getMinC() {
        return mMinC;
    }

    public String getMinF() {
        return mMinF + "°";
    }

    public String getMaxC() {
        return mMaxC + "°";
    }

    public String getMaxF() {
        return mMaxF + "°";
    }

    public String getCountry() {
        return mCountry;
    }

    public String getSpeed() {
        return mSpeed;
    }

    public String getHumidity() {
        return mHumidity;
    }

    public String getDescription(){
        return mDescription;
    }

    public Long getSunrise(){
        return mSunrise;
    }
}
