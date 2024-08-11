package animal;

import enclosure.Enclosure;
import food.Food;
import food.FoodStore;

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
        neckMassage();
        System.out.println("Giraffe given neck massage by PhysioZookeeper");
    }

    @Override
    public boolean aMonthPasses() {
        decreaseHealth();
        consumeFood();
        return getHealth() > 0;
    }

    private void neckMassage(){
        increaseHealth(4);

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
