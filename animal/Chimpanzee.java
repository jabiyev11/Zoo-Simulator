package animal;

import enclosure.Enclosure;
import food.Food;

import java.util.Arrays;

public class Chimpanzee extends Ape{

    private static final Integer CHIMPANZEE_LIFE_EXPECTANCY = 24;


    public Chimpanzee(Integer age, Character gender, Integer health, Enclosure enclosure) {
        super(age, gender, health, CHIMPANZEE_LIFE_EXPECTANCY, enclosure);
    }

    @Override
    public void eat() {

    }

    @Override
    public void treat() {
        playChase();
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }

    private void playChase(){
        setHealth(getHealth() + 4);
    }
}
