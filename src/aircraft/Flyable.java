package aircraft;

import tower.WeatherTower;

public abstract class Flyable
{
    protected WeatherTower weatherTower;

    public abstract void updateConditions();

    public void registerTower(WeatherTower p_tower){
//        Save the tower reference inside the aircraft.
        this.weatherTower = p_tower;
//        Register the aircraft with the tower.
        p_tower.register(this);
    }
}