package animal;

import enclosure.Enclosure;
import food.Food;
import food.FoodStore;

import java.util.Arrays;

public class Bear extends Animal {

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
    public void eat(Food food) {
        if (Food.FISH.equals(food)) {
            setHealth(getHealth() + 3);
            getEnclosure().addWaste(2);
        } else if (Food.STEAK.equals(food)) {
            setHealth(getHealth() + 3);
            getEnclosure().addWaste(4);
        }
    }

    @Override
    public void treat() {
        hug();
        System.out.println("Bear hugged by Zookeeper");
    }

    @Override
    public boolean aMonthPasses() {
        decreaseHealth();
        consumeFood();
        return getHealth() > 0;
    }

    private void hug() {
        increaseHealth(3);
    }

    private void consumeFood() {
        FoodStore foodStore = new FoodStore();

        if (foodStore.hasFood(Food.FISH)) {
            foodStore.takeFood(Food.FISH);
            eat(Food.FISH);
        } else if (foodStore.hasFood(Food.STEAK)) {
            foodStore.takeFood(Food.STEAK);
            eat(Food.STEAK);
        } else {
            System.out.println("No food available for " + this.getClass().getSimpleName());
        }
    }
}
