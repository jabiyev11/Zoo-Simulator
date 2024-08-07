package animal;

import enclosure.Enclosure;
import food.Food;

import java.util.Arrays;

abstract public class BigCat extends Animal{

    private static final Integer BIG_CAT_LIFE_EXPECTANCY = 24;
    private static final Food[]  BIG_CAT_EATS = {Food.STEAK, Food.CELERY};


    public BigCat(Integer age, Character gender, Integer health, Enclosure enclosure) {
        super(age, gender, BIG_CAT_EATS, health, BIG_CAT_LIFE_EXPECTANCY, enclosure);
    }

    @Override
    public boolean canEat(Food food) {
        return Arrays.asList(BIG_CAT_EATS).contains(food);
    }
}
