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
}
//{
//        "coord":{
//        "lon":139,
//        "lat":35
//        },
//        "sys":{
//        "country":"JP",
//        "sunrise":1369769524,
//        "sunset":1369821049
//        },
//        "weather":[
//        {
//        "id":804,
//        "main":"clouds",
//        "description":"overcast clouds",
//        "icon":"04n"
//        }
//        ],
//        "main":{
//        "temp":289.5,
//        "humidity":89,
//        "pressure":1013,
//        "temp_min":287.04,
//        "temp_max":292.04
//        },
//        "wind":{
//        "speed":7.31,
//        "deg":187.002
//        },
//        "rain":{
//        "3h":0
//        },
//        "clouds":{
//        "all":92
//        },
//        "dt":1369824698,
//        "id":1851632,
//        "cityName":"Shuzenji",
//        "cod":200
//        }