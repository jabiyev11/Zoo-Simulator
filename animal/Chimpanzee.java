package animal;

import enclosure.Enclosure;

public class Chimpanzee extends Ape{

    private static final Integer CHIMPANZEE_LIFE_EXPECTANCY = 24;


    public Chimpanzee(Integer age, Character gender, String[] eats, Integer health, Integer lifeExpectancy, Enclosure enclosure) {
        super(age, gender, eats, health, CHIMPANZEE_LIFE_EXPECTANCY, enclosure);
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
