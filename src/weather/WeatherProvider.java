package weather;

public class WeatherProvider {
    public static WeatherProvider instance;
    private String[] weather =
            { "SUN", "RAIN", "FOG", "SNOW" };

    public static WeatherProvider getInstance() {
        if (instance == null) instance = new WeatherProvider();;
        return instance;
    }
    public WeatherProvider() {

    }
    public String getCurrentWeather(Coordinates p_coordinates) {
        int index = (p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude()) %4;
        return weather[Math.abs(index)];
    }
}
