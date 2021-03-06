package service;

import api.OwmForecastApi;
import api.WwoForecastApi;
import callable.OwmForecastCallable;
import callable.WwoForecastCallable;
import model.ForecastResult;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import constants.Const;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;


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

    public ForecastResult getForecast() {

        ForecastResult forecastResult = new ForecastResult();

        final Call<model.wwo.Weather> forecastCallWwo = wwoForecastApi.loadWorldWeatherOnlineForecast(Const.WwoApiSettings.WWO_API_KEY, Const.CITY_NAME, Const.WwoApiSettings.FORMAT_JSON);
        final Call<model.owm.Weather> forecastCallOwm = owmForecastApi.loadOpenWeatherMapForecast(Const.OwmApiSettings.OWM_API_KEY, Const.CITY_NAME, Const.OwmApiSettings.UNITS_METRIC);

        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<model.wwo.Weather> futureWwo = pool.submit(new WwoForecastCallable(forecastCallWwo));
        Future<model.owm.Weather> futureOwm = pool.submit(new OwmForecastCallable(forecastCallOwm));

        try {
            forecastResult.setForecastOpenWeatherMap(futureOwm.get());
            forecastResult.setForecastWorldWeatherOnline(futureWwo.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return forecastResult;
    }

    public synchronized void printForecastResult(String apiServiceName, String city, String description, double temerature, double wind, double humidity, double pressure) {
        System.out.println(apiServiceName + ": " + city);
        System.out.println("description: " + description);
        System.out.println("temperature: " + temerature + Const.ForecastMeasures.TEMPERATURE);
        System.out.println("wind: " + wind + Const.ForecastMeasures.WIND_SPEED);
        System.out.println("humidity: " + humidity + Const.ForecastMeasures.HUMIDITY);
        System.out.println("pressure: " + pressure + Const.ForecastMeasures.PRESSURE);
    }

}