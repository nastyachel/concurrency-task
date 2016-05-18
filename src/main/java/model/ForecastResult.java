package model;

import model.wwo.Weather;

/**
 * Created by nastya on 18.05.16.
 */
public class ForecastResult {

    private model.wwo.Weather forecastWorldWeatherOnline;

    private model.owm.Weather forecastOpenWeatherMap;

    public Weather getForecastWorldWeatherOnline() {
        return forecastWorldWeatherOnline;
    }

    public void setForecastWorldWeatherOnline(Weather forecastWorldWeatherOnline) {
        this.forecastWorldWeatherOnline = forecastWorldWeatherOnline;
    }

    public model.owm.Weather getForecastOpenWeatherMap() {
        return forecastOpenWeatherMap;
    }

    public void setForecastOpenWeatherMap(model.owm.Weather forecastOpenWeatherMap) {
        this.forecastOpenWeatherMap = forecastOpenWeatherMap;
    }
}
