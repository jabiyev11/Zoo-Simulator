package zoo;

import enclosure.Enclosure;
import food.Food;
import food.FoodStore;
import zookeeper.ZooKeeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zoo {

    private Enclosure[] enclosures;
    private List<ZooKeeper> zooKeepers;
    public static FoodStore generalFoodStore;
    private Random random = new Random();


    public Zoo(Enclosure[] enclosures, FoodStore generalFoodStore) {
        this.enclosures = enclosures;
        Zoo.generalFoodStore = generalFoodStore;
        this.zooKeepers = new ArrayList<>();
    }

    private void aMonthPasses(){
        for(Enclosure enclosure : enclosures){
            enclosure.aMonthPasses();
        }

        for(ZooKeeper zooKeeper : zooKeepers){
            zooKeeper.aMonthPasses();
        }

        generalFoodStore.addFood(getRandomFood(), random.nextInt());
    }

    public Enclosure[] getEnclosures() {
        return enclosures;
    }

    private Food getRandomFood(){
        Food[] elements = Food.class.getEnumConstants();
        int randomIndex = random.nextInt(elements.length);
        return elements[randomIndex];
    }
}
