public abstract class Animal {

    private Integer age;
    private Character gender;
    private String[] eats;
    private Integer health;
    private Integer lifeExpectancy;

    abstract public boolean canEat(String food);

    abstract public void eat();
    abstract public void decreaseHealth();
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


}
