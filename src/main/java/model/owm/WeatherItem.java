package model.owm;

/**
 * Created by nastya on 14.05.16.
 */
public class WeatherItem {

    private String main;

    private String description;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}