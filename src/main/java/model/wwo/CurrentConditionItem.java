package model.wwo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nastya on 14.05.16.
 */
public class CurrentConditionItem {

    @SerializedName("temp_C")
    private double temperature;

    @SerializedName("windspeedMiles")
    private double wind;

    private double humidity;

    private double pressure;

    @SerializedName("weatherDesc")
    List<WeatherDescriptionItem> weatherDescription;

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getWind() {
        return wind;
    }

    public double getPressure() {
        return pressure;
    }

    public String getDescription(){
        return weatherDescription.get(0).getValue();
    }

}