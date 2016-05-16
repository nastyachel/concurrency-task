package service;

import api.OwmForecastApi;
import api.WwoForecastApi;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import constants.Const;

import java.io.IOException;


/**
 * Created by nastya on 13.05.16.
 */
public class ForecastService {

    private Retrofit owmForecastAdapter;

    private Retrofit wwoForecastAdapter;

    private OwmForecastApi owmForecastApi;

    private WwoForecastApi wwoForecastApi;

    public ForecastService() {
        setupRetrofit();
    }

    private void setupRetrofit() {

        owmForecastAdapter = new Retrofit.Builder()
                .baseUrl(Const.OwmApiSettings.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        wwoForecastAdapter = new Retrofit.Builder()
                .baseUrl(Const.WwoApiSettings.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        owmForecastApi = owmForecastAdapter.create(OwmForecastApi.class);

        wwoForecastApi = wwoForecastAdapter.create(WwoForecastApi.class);

    }

    public void getOwmForecast() {

        final Call<model.owm.Weather> forecastCall = owmForecastApi.loadOpenWeatherMapForecast(Const.OwmApiSettings.OWM_API_KEY, Const.CITY_NAME, Const.OwmApiSettings.UNITS_METRIC);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    model.owm.Weather weather = forecastCall.execute().body();
                   printForecastResult("OpenWeatherMap", weather.getCityName(),weather.getDescription(), weather.getTemperature(), weather.getHumidity(), weather.getHumidity(), weather.getPressure());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();

    }

    public void getWwoForecast(){
       final  Call<model.wwo.Weather> forecastCall = wwoForecastApi.loadWorldWeatherOnlineForecast(Const.WwoApiSettings.WWO_API_KEY, Const.CITY_NAME, Const.WwoApiSettings.FORMAT_JSON);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    model.wwo.Weather weather = forecastCall.execute().body();
                    printForecastResult("WorldWeatherOnline", weather.getLocation(),weather.getDescription(), weather.getTemperature(), weather.getHumidity(), weather.getHumidity(), weather.getPressure());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }

    private synchronized void printForecastResult(String apiServiceName, String city, String description, double temerature, double wind, double humidity, double pressure) {
        System.out.println(apiServiceName + ": " + city);
        System.out.println("description: " + description);
        System.out.println("temperature: " + temerature + Const.ForecastMeasures.TEMPERATURE);
        System.out.println("wind: " + wind + Const.ForecastMeasures.WIND_SPEED);
        System.out.println("humidity: " + humidity + Const.ForecastMeasures.HUMIDITY);
        System.out.println("pressure: " + pressure + Const.ForecastMeasures.PRESSURE);
    }

}