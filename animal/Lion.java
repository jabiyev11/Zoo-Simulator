package animal;

import enclosure.Enclosure;

public class Lion extends BigCat{


    public Lion(Integer age, Character gender, String[] eats, Integer health, Enclosure enclosure) {
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
