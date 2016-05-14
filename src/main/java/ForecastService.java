import model.owm.Weather;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;


/**
 * Created by nastya on 13.05.16.
 */
public class ForecastService {

    private Retrofit owmForecast;

    private Retrofit wwoForecast;

    private ForecastApi forecastApi;

    public ForecastService() {
        setupRetrofit();
    }

    private void setupRetrofit() {

        owmForecast = new Retrofit.Builder()
                .baseUrl(Const.OwmApiSettings.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        forecastApi = owmForecast.create(ForecastApi.class);

    }

    public void getOwmForecast() {

        Call<Weather> forecastCall = forecastApi.loadForecast(Const.CITY_NAME, Const.OwmApiSettings.OWM_API_KEY, Const.OwmApiSettings.UNITS_METRIC);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Weather weather = forecastCall.execute().body();
                    printForecastResult("OpenWeatherMap", weather.getCityName(), weather.getTemperature(), weather.getHumidity(), weather.getHumidity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();

    }

    private void printForecastResult(String apiServiceName, String city, double temerature, double wind, double humidity){
        System.out.println(apiServiceName+": "+city);
        System.out.println("temperature: "+temerature+ Const.ForecastMeasures.TEMPERATURE);
        System.out.println("wind: "+wind+Const.ForecastMeasures.WIND_SPEED);
        System.out.println("humidity: "+humidity+Const.ForecastMeasures.HUMIDITY);
    }

}