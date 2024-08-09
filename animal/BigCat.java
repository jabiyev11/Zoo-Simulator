package animal;

import enclosure.Enclosure;
import food.Food;
import food.FoodStore;

import java.util.Arrays;

abstract public class BigCat extends Animal {

    private static final Integer BIG_CAT_LIFE_EXPECTANCY = 24;
    private static final Food[] BIG_CAT_EATS = {Food.STEAK, Food.CELERY};


    public BigCat(Integer age, Character gender, Integer health, Enclosure enclosure) {
        super(age, gender, BIG_CAT_EATS, health, BIG_CAT_LIFE_EXPECTANCY, enclosure);
    }

    @Override
    public boolean canEat(Food food) {
        return Arrays.asList(BIG_CAT_EATS).contains(food);
    }

    @Override
    public void eat(Food food) {
        if (Food.STEAK.equals(food)) {
            setHealth(getHealth() + 3);
            getEnclosure().addWaste(4);
        } else if (Food.CELERY.equals(food)) {
            getEnclosure().addWaste(1);
        }
    }

    @Override
    public boolean aMonthPasses() {
        decreaseHealth();
        consumeFood();
        return getHealth() > 0;
    }


    private void consumeFood() {
        FoodStore foodStore = new FoodStore();

        if (foodStore.hasFood(Food.STEAK)) {
            foodStore.takeFood(Food.STEAK);
            eat(Food.STEAK);
        } else if (foodStore.hasFood(Food.CELERY)) {
            foodStore.takeFood(Food.CELERY);
            eat(Food.CELERY);
        } else {
            System.out.println("No food available for " + this.getClass().getSimpleName());
        }
    }
}
