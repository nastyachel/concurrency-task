package model.wwo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nastya on 14.05.16.
 */
public class Data {

    @SerializedName("current_condition")
    private List<CurrentConditionItem> currentCondition;

    private List<RequestItem> request;

    public String getLocation(){
        return request.get(0).getQuery();
    }

    public double getTemperature() {
        return currentCondition.get(0).getTemperature();
    }

    public double getHumidity() {
        return currentCondition.get(0).getHumidity();
    }

    public double getWind() {
        return currentCondition.get(0).getWind();
    }

    public double getPressure() {
        return currentCondition.get(0).getPressure();
    }

    public String getDescription() {
        return currentCondition.get(0).getDescription();
    }

}
