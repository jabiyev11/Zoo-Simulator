package zookeeper;

import animal.Animal;
import animal.Bear;
import animal.BigCat;
import enclosure.Enclosure;
import zoo.Zoo;

import java.util.*;

public class ZooKeeper {

    private Enclosure enclosure;

    public ZooKeeper(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public void aMonthPasses() {
        removeWaste();
        moveFoodFromZooToEnclosure();
        giveTreatToAnimals();
    }

    private void removeWaste() {
        if (enclosure.getWaste() > 20) {
            System.out.println("Zookeeper removed 20 waste");
            enclosure.removeWaste(20);
        } else {
            System.out.println("All waste removed by Zookeeper");
            enclosure.setWaste(0);
        }
    }

    private void moveFoodFromZooToEnclosure(){
        int movedQuantity = Zoo.generalFoodStore.takeUpTo20Food(enclosure.getFoodStore());
        System.out.println("Successfully moved " + movedQuantity + " items");
    }

    protected void giveTreatToAnimals(){
        List<Animal> animals = new ArrayList<>(enclosure.getAnimals());
        Collections.shuffle(animals, new Random());

        int treatCount = 0;
        for(Animal animal : animals){
            if(treatCount < 2 && (animal instanceof BigCat || animal instanceof Bear)){
                animal.treat();
                treatCount++;
            }else {
                break;
            }
        }
        System.out.println("Gave treat to " + treatCount + " animals");
    }


    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }
}
