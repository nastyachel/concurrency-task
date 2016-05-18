package callable;

import model.wwo.Weather;
import retrofit2.Call;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * Created by nastya on 16.05.16.
 */
public class WwoForecastCallable implements Callable {

    Call<Weather> call;

    public WwoForecastCallable(Call<Weather> call){
        this.call = call;
    }

    public Weather call(){
        try {
            Weather weather = call.execute().body();

            return weather;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
