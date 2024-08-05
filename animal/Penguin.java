package animal;

import enclosure.Enclosure;

public class Penguin extends Animal{

    private static final Integer PENGUIN_LIFE_EXPECTANCY = 15;

    public Penguin(Integer age, Character gender, String[] eats, Integer health, Integer lifeExpectancy, Enclosure enclosure) {
        super(age, gender, eats, health, PENGUIN_LIFE_EXPECTANCY, enclosure);
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
