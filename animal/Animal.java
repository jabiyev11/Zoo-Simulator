package animal;

import enclosure.Enclosure;
import food.Food;

public abstract class Animal {

    private Integer age;
    private Character gender;
    private Food[] eats;
    private Integer health;
    private Integer lifeExpectancy;
    private Enclosure enclosure;

    public Animal(Integer age, Character gender, Food[] eats, Integer health, Integer lifeExpectancy, Enclosure enclosure) {
        this.age = age;
        this.gender = gender;
        this.eats = eats;
        this.health = health;
        this.lifeExpectancy = lifeExpectancy;
        this.enclosure = enclosure;
    }

    abstract public boolean canEat(Food food);

    abstract public void eat();

    public void decreaseHealth() {

        this.health -= 2;
    }

    abstract public void treat();

    abstract public boolean aMonthPasses();

    public Integer getAge() {
        return age;
    }

    public Character getGender() {
        return gender;
    }

    public Food[] getEats() {
        return eats;
    }

    public Integer getHealth() {
        return health;
    }

    public Integer getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }
}
