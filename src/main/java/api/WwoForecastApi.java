package api;

import constants.Const;
import model.wwo.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nastya on 14.05.16.
 */
public interface WwoForecastApi {

    @GET(Const.WwoApiSettings.URL+ Const.WwoApiSettings.PREMIUM+ Const.WwoApiSettings.VERSION+ Const.WwoApiSettings.WEATHER)
    Call<Weather> loadWorldWeatherOnlineForecast(@Query(Const.WwoApiSettings.KEY) String key,
                                                 @Query(Const.WwoApiSettings.QUERY) String query,
                                                 @Query(Const.WwoApiSettings.FORMAT) String format);
}