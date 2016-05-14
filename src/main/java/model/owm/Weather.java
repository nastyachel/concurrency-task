package model.owm;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nastya on 13.05.16.
 */
public class Weather {

    private List<WeatherItem> weather;

    private Main main;

    private Wind wind;

    @SerializedName("name")
    private String cityName;

    public double getWind() {
        return wind.getSpeed();
    }

    public double getTemperature() {
        return main.getTemperature();
    }

    public double getHumidity(){
        return main.getHumidity();
    }

    public double getPressure(){
        return main.getPressure();
    }

    public String getCityName() {
        return cityName;
    }

    public String getDescription() {
        return weather.get(0).getDescription();
    }

}