package zookeeper;

import animal.*;
import enclosure.Enclosure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PlayZooKeeper extends ZooKeeper{

    public PlayZooKeeper(Enclosure enclosure) {
        super(enclosure);
    }

    @Override
    protected void giveTreatToAnimals() {
        List<Animal> animals = new ArrayList<>(getEnclosure().getAnimals());
        Collections.shuffle(animals, new Random());

        int treatCount = 0;
        for(Animal animal : animals){
            if(treatCount < 2 && (animal instanceof BigCat || animal instanceof Bear || animal instanceof Ape || animal instanceof Penguin)){
                animal.treat();
                treatCount++;
            }else {
                break;
            }
        }
        System.out.println("Gave treat to " + treatCount + " animals");
    }
}
