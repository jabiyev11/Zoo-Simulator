package animal;

import enclosure.Enclosure;

abstract public class Ape extends Animal{


    public Ape(Integer age, Character gender, String[] eats, Integer health, Integer lifeExpectancy, Enclosure enclosure) {
        super(age, gender, eats, health, lifeExpectancy, enclosure);
    }
}
