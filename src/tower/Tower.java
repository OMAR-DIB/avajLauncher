package tower;

import aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {

        // Add aircraft
        observers.add(p_flyable);
        // Log registration
        System.out.println("Tower says: " + p_flyable + " registered to weather tower.");
    }

    public void unregister(Flyable p_flyable) {
        // Remove aircraft
        observers.remove(p_flyable);
        // Log unregistration
        System.out.println("Tower says: " + p_flyable + " unregistered from weather tower.");
    }

    public void conditionChanged() {
        // Notify all registered aircraft
        // iterate over a copy instead of observers only
        for (Flyable p_flyable : new ArrayList<>(observers)) {
            p_flyable.updateConditions();
        }
    }
}
