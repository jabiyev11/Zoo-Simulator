package animal;

import enclosure.Enclosure;
import food.Food;

public class Lion extends BigCat{


    public Lion(Integer age, Character gender, Integer health, Enclosure enclosure) {
        super(age, gender, health, enclosure);
    }

    @Override
    public void treat() {
        stroked();
    }


    private void stroked(){
        setHealth(getHealth() + 2);
    }

}
