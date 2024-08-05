import food.FoodStore;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {

    private List<Animal> animals;

    private FoodStore foodStore;
    private Integer waste;

    public Enclosure(){
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

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public void removeAnimal(Animal animal){
        animals.remove(animal);
    }


    public Integer sizeOfAnimalList(){
        return animals.size();
    }

    public void removeWaste(Integer wasteToRemove){
        waste -= wasteToRemove;
    }

    public void addWaste(Integer wasteToAdd){
        waste += wasteToAdd;
    }

    public Integer getWaste() {
        return waste;
    }

    public void aMonthPasses(){

        for(Animal animal : animals){
            animal.aMonthPasses();
        }
    }
}
