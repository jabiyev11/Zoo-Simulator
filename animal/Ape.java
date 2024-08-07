package animal;

import enclosure.Enclosure;
import food.Food;

import java.util.Arrays;

abstract public class Ape extends Animal{

    private static Food[] APE_EATS = {Food.ICE_CREAM, Food.FRUIT};


    public Ape(Integer age, Character gender, Integer health, Integer lifeExpectancy, Enclosure enclosure) {
        super(age, gender, APE_EATS, health, lifeExpectancy, enclosure);
    }

    @Override
    public boolean canEat(Food food) {
        return Arrays.asList(APE_EATS).contains(food);
    }
}
