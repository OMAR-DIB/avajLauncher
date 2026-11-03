package aircraft;

import weather.Coordinates;

public class AircraftFactory {
    public static AircraftFactory instance;
    public long id = 1;

    private AircraftFactory()
    {
        super();
    }

    public static AircraftFactory getInstance() {
        if(instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }
    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        switch (p_type) {
            case "Helicopter": return new Helicopter(id++, p_name, p_coordinates);
            case "JetPlane":   return new JetPlane(id++, p_name, p_coordinates);
            case "Balloon":    return new Balloon(id++, p_name, p_coordinates);
            default:
                throw new IllegalArgumentException("Unknown aircraft type: " + p_type);
            }
    }
}
