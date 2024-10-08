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
    public void treat() {
        System.out.println("Chimpanzee chased by PlayZookeeper");
        playChase();
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }

    private void playChase(){
        increaseHealth(4);
    }
}
