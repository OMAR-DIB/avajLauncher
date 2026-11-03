package aircraft;

import weather.Coordinates;

public class JetPlane extends Aircraft{

    public JetPlane(long id, String name, Coordinates coordinates) {
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
                lat += 10;
                height = Math.min(height + 2, 100);
                message = "Clear skies ahead, full throttle!";
                break;
            case "RAIN":
                lat += 5;
                message = "It's raining. Better watch out for lightings.";
                break;
            case "FOG":
                lat += 1;
                message = "Fog on the radar, slowing down.";
                break;
            case "SNOW":
                height = Math.max(height - 7, 0);
                message = "OMG! Winter is coming!";
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
