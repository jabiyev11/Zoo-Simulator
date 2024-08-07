package animal;

import enclosure.Enclosure;
import food.Food;

import java.util.Arrays;

public class Bear extends Animal{

    private static final Integer BEAR_LIFE_EXPECTANCY = 18;
    private static final Food[] BEAR_EATS = {Food.FISH, Food.STEAK};

    public Bear(Integer age, Character gender, Integer health, Enclosure enclosure) {
        super(age, gender, BEAR_EATS, health, BEAR_LIFE_EXPECTANCY, enclosure);
    }

    @Override
    public boolean canEat(Food food) {
        return Arrays.asList(BEAR_EATS).contains(food);
    }

    @Override
    public void eat() {

    }

    @Override
    public void treat() {
        hug();
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }

    private void hug(){
        setHealth(getHealth() + 3);
    }
}
