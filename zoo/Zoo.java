package zoo;

import enclosure.Enclosure;
import food.FoodStore;

public class Zoo {

    private Enclosure[] enclosures;
    public static FoodStore generalFoodStore;


    public Zoo(Enclosure[] enclosures, FoodStore generalFoodStore) {
        this.enclosures = enclosures;
        Zoo.generalFoodStore = generalFoodStore;
    }

    private void aMonthPasses(){

    }

    public Enclosure[] getEnclosures() {
        return enclosures;
    }
}
