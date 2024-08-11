package enclosure;

import animal.Animal;
import food.FoodStore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Enclosure {

    private List<Animal> animals;

    private FoodStore foodStore;
    private Integer waste;

    public Enclosure() {
        this.animals = new ArrayList<>(20);
        this.foodStore = new FoodStore();
        this.waste = 0;
    }


    public List<Animal> getAnimals() {
        return animals;
    }

    public FoodStore getFoodStore() {
        return foodStore;
    }

    public void addAnimal(Animal animal) {
        if (animals.size() >= 20) {
            throw new IllegalArgumentException("Enclosure is full, cannot hold more than 20 animals");
        }
        animals.add(animal);
        System.out.println(animal + " added to Enclosure");
    }

    public void removeAnimal(Animal animal) {
        if (!animals.isEmpty()) {
            animals.remove(animal);
        }else{
            System.out.println("Cannot remove any animal, Enclosure is already empty");
        }
    }

    public Integer sizeOfAnimalList() {
        return animals.size();
    }

    public void removeWaste(Integer wasteToRemove) {
        waste -= wasteToRemove;
        if(waste < 0) waste = 0;
        System.out.println("Removed waste: " + wasteToRemove + " Total waste: " + waste);
    }

    public void addWaste(Integer wasteToAdd) {
        waste += wasteToAdd;
        System.out.println("Added waste: " + wasteToAdd + " Total waste: " + waste);
    }

    public Integer getWaste() {
        return waste;
    }

    public void setWaste(Integer waste) {
        this.waste = waste;
    }


    public void aMonthPasses() {
        Iterator<Animal> iterator = animals.iterator();
        while(iterator.hasNext()) {
            Animal animal = iterator.next();
            if (!animal.aMonthPasses()) { //returns whether dead or not
                removeAnimal(animal); //remove dead animal
            }
        }
    }

//    @Override
//    public String toString() {
//        return "Enclosure{" +
//                "animals=" + animals +
//                ", foodStore=" + foodStore +
//                ", waste=" + waste +
//                '}';
//    }
}
