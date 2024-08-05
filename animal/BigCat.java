package animal;

import enclosure.Enclosure;

abstract public class BigCat extends Animal{

    private static final Integer BIG_CAT_LIFE_EXPECTANCY = 24;


    public BigCat(Integer age, Character gender, String[] eats, Integer health, Enclosure enclosure) {
        super(age, gender, eats, health, BIG_CAT_LIFE_EXPECTANCY, enclosure);
    }
}
