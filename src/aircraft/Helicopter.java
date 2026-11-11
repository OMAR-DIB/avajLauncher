package aircraft;

import weather.Coordinates;

public class Helicopter extends Aircraft{
    public Helicopter(long id, String name, Coordinates coordinates) {
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
                lon += 10;
                height = Math.min(height + 2, 100);
                message = "This is hot.";
                break;
            case "RAIN":
                lon += 5;
                message = "I'm wet! Good thing I waterproofed.";
                break;
            case "FOG":
                lon += 1;
                message = "I can barely see anything!";
                break;
            case "SNOW":
                height = Math.max(height - 12, 0);
                message = "My rotor is going to freeze!";
                break;
            default:
                message = "Weather unknown.";
        }


        coordinates = new Coordinates(lon, lat, height);

        System.out.println(this + ": " + message);

        if (height == 0) {
            System.out.println(this + " landing.");
            weatherTower.unregister(this);
        }
    }
}
