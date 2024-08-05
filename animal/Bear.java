package animal;

import enclosure.Enclosure;

public class Bear extends Animal{

    private static final Integer BEAR_LIFE_EXPECTANCY = 18;

    public Bear(Integer age, Character gender, String[] eats, Integer health, Integer lifeExpectancy, Enclosure enclosure) {
        super(age, gender, eats, health, BEAR_LIFE_EXPECTANCY, enclosure);
    }

    @Override
    public boolean canEat(String food) {
        return false;
    }

    @Override
    public void eat() {

    }

    @Override
    public void treat() {

    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }
}
