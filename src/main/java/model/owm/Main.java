package model.owm;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nastya on 13.05.16.
 */
public class Main {

    @SerializedName("temp")
    private double temperature;

    private double pressure;

    private double humidity;

    public double getTemperature() {
        return temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }
}