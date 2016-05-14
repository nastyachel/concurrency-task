import model.wwo.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nastya on 14.05.16.
 */
public interface WwoForecastApi {

    @GET(Const.WwoApiSettings.URL+Const.WwoApiSettings.PREMIUM+Const.WwoApiSettings.VERSION+Const.WwoApiSettings.WEATHER)
    Call<Weather> loadWorldWeatherOnlineForecast(@Query(Const.WwoApiSettings.KEY) String key,
                                                 @Query(Const.WwoApiSettings.QUERY) String query,
                                                 @Query(Const.WwoApiSettings.FORMAT) String format);
}
//http://api.worldweatheronline.com/premium/v1/weather.ashx?key=9d44a297ae03427ab5811703161405&q=Dnipropetrovsk&format=json