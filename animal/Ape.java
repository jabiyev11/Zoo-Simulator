package animal;

import enclosure.Enclosure;
import food.Food;
import food.FoodStore;

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

    @Override
    public void eat(Food food) {
        if(Food.FRUIT.equals(food)){
            setHealth(getHealth() + 2);
            getEnclosure().addWaste(3);
        }else if(Food.ICE_CREAM.equals(food)){
            setHealth(getHealth() + 1);
            getEnclosure().addWaste(3);
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

        if (foodStore.hasFood(Food.FRUIT)) {
            foodStore.takeFood(Food.FRUIT);
            eat(Food.FRUIT);
        } else if (foodStore.hasFood(Food.ICE_CREAM)) {
            foodStore.takeFood(Food.ICE_CREAM);
            eat(Food.ICE_CREAM);
        } else {
            System.out.println("No food available for " + this.getClass().getSimpleName());
        }
    }
}
