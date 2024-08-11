package animal;

import enclosure.Enclosure;
import food.Food;

public class Tiger extends BigCat{


    public Tiger(Integer age, Character gender, Integer health, Enclosure enclosure) {
        super(age, gender, health, enclosure);
    }


    @Override
    public void treat() {
        stroked();
        System.out.println("Tiger stroked by Zookeeper");
    }


    private void stroked(){
        increaseHealth(3);
    }
}
