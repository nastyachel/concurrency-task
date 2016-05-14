import model.owm.Weather;
import retrofit2.Call;

import java.io.IOException;

/**
 * Created by nastya on 14.05.16.
 */
public class OwmThread extends Thread {

    private Call<Weather> call;

    public OwmThread(Call<Weather> call){

    }

}
