package animal;

import enclosure.Enclosure;
import food.Food;

import java.util.Arrays;

public class Elephant extends Animal{

    private static final Integer ELEPHANT_LIFE_EXPECTANCY = 36;
    private static final Food[] ELEPHANT_EATS = {Food.FRUIT, Food.HAY};

    public Elephant(Integer age, Character gender, Integer health, Enclosure enclosure) {
        super(age, gender, ELEPHANT_EATS, health, ELEPHANT_LIFE_EXPECTANCY, enclosure);
    }

    @Override
    public boolean canEat(Food food) {
        return Arrays.asList(ELEPHANT_EATS).contains(food);
    }

    @Override
    public void eat() {

    }

    @Override
    public void treat() {
        bath();
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }

    private void bath(){
        setHealth(getHealth() + 5);
    }
}
