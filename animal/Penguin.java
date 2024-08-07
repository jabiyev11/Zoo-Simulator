package animal;

import enclosure.Enclosure;
import food.Food;

public class Penguin extends Animal{

    private static final Integer PENGUIN_LIFE_EXPECTANCY = 15;
    private static final Food[] PENGUIN_EATS = {Food.FISH, Food.ICE_CREAM};

    public Penguin(Integer age, Character gender, Integer health, Enclosure enclosure) {
        super(age, gender, PENGUIN_EATS, health, PENGUIN_LIFE_EXPECTANCY, enclosure);
    }

    @Override
    public boolean canEat(Food food) {
        return false;
    }

    @Override
    public void eat() {

    }

    @Override
    public void treat() {
        watchAFilm();
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }

    private void watchAFilm(){
        setHealth(getHealth() + 2);
    }
}
