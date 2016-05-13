import model.owm.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nastya on 12.05.16.
 */
public interface ForecastApi {

    @GET(Const.OwmApiSettings.URL+Const.OwmApiSettings.DATA+Const.OwmApiSettings.VERSION+Const.OwmApiSettings.WEATHER)
    public Call<Weather> loadForecast(@Query(Const.OwmApiSettings.ID) String id, @Query(Const.OwmApiSettings.APP_ID) String apiKey);
}

//http://api.openweathermap.org/data/2.5/forecast/city?id=524901&APPID={APIKEY}