package animal;

import enclosure.Enclosure;
import food.Food;
import food.FoodStore;

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
    public void eat(Food food) {
        if(Food.FRUIT.equals(food)){
            setHealth(getHealth() + 2);
            getEnclosure().addWaste(3);
        } else if (Food.HAY.equals(food)) {
            setHealth(getHealth() + 1);
            getEnclosure().addWaste(4);
        }
    }

    @Override
    public void treat() {
        bath();
    }

    @Override
    public boolean aMonthPasses() {
        decreaseHealth();
        consumeFood();
        return getHealth() > 0;
    }

    private void bath(){
        setHealth(getHealth() + 5);
    }

    private void consumeFood() {
        FoodStore foodStore = new FoodStore();

        if (foodStore.hasFood(Food.HAY)) {
            foodStore.takeFood(Food.HAY);
            eat(Food.HAY);
        } else if (foodStore.hasFood(Food.FRUIT)) {
            foodStore.takeFood(Food.FRUIT);
            eat(Food.FRUIT);
        } else {
            System.out.println("No food available for " + this.getClass().getSimpleName());
        }
    }
}
