package animal;

import enclosure.Enclosure;
import food.Food;

public class Gorilla extends Ape{

    private static final Integer GORILLA_LIFE_EXPECTANCY = 32;

    public Gorilla(Integer age, Character gender, Integer health, Enclosure enclosure) {
        super(age, gender, health, GORILLA_LIFE_EXPECTANCY, enclosure);
    }


    @Override
    public void treat() {
        System.out.println("Gorilla painted with PlayZookeeper");
        painting();
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }

    private void painting(){
        increaseHealth(4);
    }
}
