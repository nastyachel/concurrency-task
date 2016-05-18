import model.ForecastResult;
import service.ForecastService;

/**
 * Created by nastya on 12.05.16.
 */
public class App {

    public static void main(String[] args) {
        ForecastService service = new ForecastService();
        ForecastResult forecastResult = service.getForecast();

        model.wwo.Weather forecastWorldWeatherOnline = forecastResult.getForecastWorldWeatherOnline();
        model.owm.Weather forecastOpenWeatherMap = forecastResult.getForecastOpenWeatherMap();

        if (forecastOpenWeatherMap != null)
            service.printForecastResult("OpenWeatherMap", forecastOpenWeatherMap.getCityName(), forecastOpenWeatherMap.getDescription(),
                    forecastOpenWeatherMap.getTemperature(), forecastOpenWeatherMap.getHumidity(), forecastOpenWeatherMap.getHumidity(), forecastOpenWeatherMap.getPressure());

        if (forecastOpenWeatherMap != null)
            service.printForecastResult("WorldWeatherOnline", forecastWorldWeatherOnline.getLocation(), forecastWorldWeatherOnline.getDescription(), forecastWorldWeatherOnline.getTemperature(),
                    forecastWorldWeatherOnline.getHumidity(), forecastWorldWeatherOnline.getHumidity(), forecastWorldWeatherOnline.getPressure());

    }
}