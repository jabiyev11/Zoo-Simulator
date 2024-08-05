package animal;

import enclosure.Enclosure;

public class Giraffe extends Animal{

    private static final Integer GIRAFFE_LIFE_EXPECTANCY = 28;

    public Giraffe(Integer age, Character gender, String[] eats, Integer health, Integer lifeExpectancy, Enclosure enclosure) {
        super(age, gender, eats, health, GIRAFFE_LIFE_EXPECTANCY, enclosure);
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
