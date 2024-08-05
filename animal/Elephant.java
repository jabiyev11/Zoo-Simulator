package animal;

import enclosure.Enclosure;

public class Elephant extends Animal{

    private static final Integer ELEPHANT_LIFE_EXPECTANCY = 36;

    public Elephant(Integer age, Character gender, String[] eats, Integer health, Integer lifeExpectancy, Enclosure enclosure) {
        super(age, gender, eats, health, ELEPHANT_LIFE_EXPECTANCY, enclosure);
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
