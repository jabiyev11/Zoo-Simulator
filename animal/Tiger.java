package animal;

import enclosure.Enclosure;
import food.Food;

public class Tiger extends BigCat{


    public Tiger(Integer age, Character gender, Integer health, Enclosure enclosure) {
        super(age, gender, health, enclosure);
    }


    @Override
    public void eat() {

    }

    @Override
    public void treat() {
        stroked();
    }

    @Override
    public boolean aMonthPasses() {
        return false;
    }

    private void stroked(){
        setHealth(getHealth() + 3);
    }
}
