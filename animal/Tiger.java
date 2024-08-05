package animal;

import enclosure.Enclosure;

public class Tiger extends BigCat{


    public Tiger(Integer age, Character gender, String[] eats, Integer health, Enclosure enclosure) {
        super(age, gender, eats, health, enclosure);
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
