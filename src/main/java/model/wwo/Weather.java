package model.wwo;

/**
 * Created by nastya on 13.05.16.
 */
public class Weather {

    private Data data;

    public double getTemperature() {
        return data.getTemperature();
    }

    public double getHumidity() {
        return data.getHumidity();
    }

    public double getWind() {
        return data.getWind();
    }

    public double getPressure() {
        return data.getPressure();
    }

    public String getDescription() {
        return data.getDescription();
    }

    public String getLocation(){
        return data.getLocation();
    }

}
