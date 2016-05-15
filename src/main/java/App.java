import service.ForecastService;

/**
 * Created by nastya on 12.05.16.
 */
public class App {

    public static void main(String[] args) {
        ForecastService service = new ForecastService();
        // TODO call tha weather rest
        service.getWwoForecast();
        service.getOwmForecast();
    }
}