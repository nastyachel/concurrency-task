import model.owm.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nastya on 12.05.16.
 */
public interface OwmForecastApi {

    @GET(Const.OwmApiSettings.URL + Const.OwmApiSettings.DATA + Const.OwmApiSettings.VERSION + Const.OwmApiSettings.WEATHER)
    Call<Weather> loadOpenWeatherMapForecast(@Query(Const.OwmApiSettings.APP_ID) String apiKey,
                                             @Query(Const.OwmApiSettings.QUERY) String q,
                                             @Query(Const.OwmApiSettings.UNITS) String units);
}