package animal;

import enclosure.Enclosure;
import food.Food;
import food.FoodStore;

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
    public void eat(Food food) {
        if(Food.ICE_CREAM.equals(food)){
            setHealth(getHealth() + 1);
            getEnclosure().addWaste(3);
        }else if(Food.FISH.equals(food)){
            setHealth(getHealth() + 3);
            getEnclosure().addWaste(2);
        }
    }

    @Override
    public void treat() {
        watchAFilm();
        System.out.println("Penguin watched a film with PlayZookeeper");
    }

    @Override
    public boolean aMonthPasses() {
        decreaseHealth();
        consumeFood();
        return getHealth() > 0;
    }

    private void watchAFilm(){
        increaseHealth(2);
    }

    private void consumeFood() {
        FoodStore foodStore = new FoodStore();

        if (foodStore.hasFood(Food.FISH)) {
            foodStore.takeFood(Food.FISH);
            eat(Food.FISH);
        } else if (foodStore.hasFood(Food.ICE_CREAM)) {
            foodStore.takeFood(Food.ICE_CREAM);
            eat(Food.ICE_CREAM);
        } else {
            System.out.println("No food available for " + this.getClass().getSimpleName());
        }
    }
}
