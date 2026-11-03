import aircraft.AircraftFactory;
import aircraft.Flyable;
import tower.WeatherTower;
import weather.Coordinates;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // 1. Create the WeatherTower
        WeatherTower tower = new WeatherTower();

        // 2. Get the AircraftFactory
        AircraftFactory factory = AircraftFactory.getInstance();

        // 3. Create coordinates
        Coordinates c1 = new Coordinates(2, 3, 10);
        Coordinates c2 = new Coordinates(5, 7, 20);
        Coordinates c3 = new Coordinates(8, 4, 30);

        // 4. Create aircraft
        Flyable b1 = factory.newAircraft("Balloon", "B1", c1);
        Flyable j1 = factory.newAircraft("JetPlane", "J1", c2);
        Flyable h1 = factory.newAircraft("Helicopter", "H1", c3);

        // 5. Register aircraft
        b1.registerTower(tower);
        j1.registerTower(tower);
        h1.registerTower(tower);

        // 6. Run 5 weather changes
        for (int i = 0; i < 5; i++) {

            System.out.println("\n--- Weather cycle " + (i + 1) + " ---");

            tower.changeWeather();
        }
    }
}