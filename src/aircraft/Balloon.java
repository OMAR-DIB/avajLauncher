package aircraft;

import weather.Coordinates;

public class Balloon extends Aircraft{

    public Balloon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }
    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        int lon = coordinates.getLongitude();
        int lat = coordinates.getLatitude();
        int height = coordinates.getHeight();
        String message;

        switch (weather) {
            case "SUN":
                lon += 2;
                height = Math.min(height + 4, 100);
                message = "Let's enjoy the good weather and take some pics.";
                break;
            case "RAIN":
                height = Math.max(height - 5, 0);
                message = "Damn you rain! You messed up my balloon.";
                break;
            case "FOG":
                height = Math.max(height - 3, 0);
                message = "Can't see a thing in this fog!";
                break;
            case "SNOW":
                height = Math.max(height - 15, 0);
                message = "It's snowing. We're gonna crash.";
                break;
            default:
                message = "Weather unknown.";
        }


        System.out.println(this + ": " + message);


        if (height == 0) {
            System.out.println(this + " landing.");
            weatherTower.unregister(this);
        } else {
            coordinates = new Coordinates(lon, lat, height);
        }
    }
}
