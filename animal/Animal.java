package animal;

import enclosure.Enclosure;
import food.Food;

import java.util.Arrays;
import java.util.Objects;

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

    abstract public void eat(Food food);

    public void decreaseHealth() {

        this.health -= 2;
        System.out.println("Health of " + this.getClass().getSimpleName() + " decreased by 2");
    }

    public void increaseHealth(Integer healthToIncrease){
        this.health += healthToIncrease;
        System.out.println("Health increased by" + healthToIncrease);
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
        if(health < 0){
            System.out.println(this.getClass().getSimpleName() + " died");
        }
        return health;
    }

    public Integer getLifeExpectancy() {
        return lifeExpectancy;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal animal)) return false;
        return Objects.equals(age, animal.age) && Objects.equals(gender, animal.gender) && Arrays.equals(eats, animal.eats) && Objects.equals(health, animal.health) && Objects.equals(lifeExpectancy, animal.lifeExpectancy) && Objects.equals(enclosure, animal.enclosure);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(age, gender, health, lifeExpectancy, enclosure);
        result = 31 * result + Arrays.hashCode(eats);
        return result;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", gender=" + gender +
                ", eats=" + Arrays.toString(eats) +
                ", health=" + health +
                ", lifeExpectancy=" + lifeExpectancy +
                ", enclosure=" + enclosure +
                '}';
    }
}
