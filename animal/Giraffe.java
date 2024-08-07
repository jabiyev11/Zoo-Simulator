package animal;

import enclosure.Enclosure;
import food.Food;

import java.util.Arrays;

public class Giraffe extends Animal{

    private static final Integer GIRAFFE_LIFE_EXPECTANCY = 28;
    private static final Food[] GIRAFFE_EATS = {Food.FRUIT, Food.HAY};

    public Giraffe(Integer age, Character gender, Integer health, Enclosure enclosure) {
        super(age, gender, GIRAFFE_EATS, health, GIRAFFE_LIFE_EXPECTANCY, enclosure);
    }

    @Override
    public boolean canEat(Food food) {
        return Arrays.asList(GIRAFFE_EATS).contains(food);
    }

    @Override
    public void eat() {

    }

    @Override
    public void treat() {
        neckMassage();
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }

    private void neckMassage(){
        setHealth(getHealth() + 4);
    }
}
