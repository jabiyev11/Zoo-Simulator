package animal;

import enclosure.Enclosure;

public abstract class Animal {

    private Integer age;
    private Character gender;
    private String[] eats;
    private Integer health;
    private Integer lifeExpectancy;
    private Enclosure enclosure;

    public Animal(Integer age, Character gender, String[] eats, Integer health, Integer lifeExpectancy, Enclosure enclosure) {
        this.age = age;
        this.gender = gender;
        this.eats = eats;
        this.health = health;
        this.lifeExpectancy = lifeExpectancy;
        this.enclosure = enclosure;
    }

    abstract public boolean canEat(String food);

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

    public String[] getEats() {
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

}
