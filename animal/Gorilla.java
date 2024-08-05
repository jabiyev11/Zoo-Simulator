package animal;

import enclosure.Enclosure;

public class Gorilla extends Ape{

    private static final Integer GORILLA_LIFE_EXPECTANCY = 32;

    public Gorilla(Integer age, Character gender, String[] eats, Integer health, Integer lifeExpectancy, Enclosure enclosure) {
        super(age, gender, eats, health, GORILLA_LIFE_EXPECTANCY, enclosure);
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
