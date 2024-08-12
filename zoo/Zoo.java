package zoo;

import animal.Animal;
import animal.Bear;
import animal.Lion;
import animal.Tiger;
import enclosure.Enclosure;
import exception.AnimalWithoutEnclosureException;
import exception.ZooKeeperWithoutEnclosureException;
import food.Food;
import food.FoodStore;
import zookeeper.PhysioZooKeeper;
import zookeeper.PlayZooKeeper;
import zookeeper.ZooKeeper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Zoo {

    private static Enclosure[] enclosures;
    private static List<ZooKeeper> zooKeepers;
    public static FoodStore generalFoodStore;
    private static final Random random = new Random();

    private static final String ZOO_DATA_FILE = "data/myZoo.txt";


    public Zoo() {
        Zoo.enclosures = new Enclosure[0];
        Zoo.generalFoodStore = new FoodStore();
        Zoo.zooKeepers = new ArrayList<>();
    }

    private static void aMonthPasses(){
//        for(int i = 0; i < 3; i++){
            for (Enclosure enclosure : enclosures) {
                enclosure.aMonthPasses();
            }

            for (ZooKeeper zooKeeper : zooKeepers) {
                zooKeeper.aMonthPasses();
            }

            generalFoodStore.addFood(getRandomFood(), random.nextInt(1, 100));
        }
//    }

    public Enclosure[] getEnclosures() {
        return enclosures;
    }

    private static Food getRandomFood(){
        Food[] elements = Food.class.getEnumConstants();
        int randomIndex = random.nextInt(elements.length);
        return elements[randomIndex];
    }

    private static void addEnclosure(Enclosure enclosure){
        List<Enclosure> enclosureList = new ArrayList<>(Arrays.asList(enclosures));
        enclosureList.add(enclosure);
        enclosures = enclosureList.toArray(new Enclosure[0]);
    }

    private static void go(){
        aMonthPasses();
    }

    public static void loadConfiguration(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Enclosure currentEnclosure = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("zoo:")) {
                    // Ensure Zoo is created or used correctly
                     Zoo zoo = new Zoo(); // This may not be needed if Zoo is already instantiated
                } else if (line.startsWith("enclosure:")) {
                    int waste = Integer.parseInt(line.split(":")[1]);
                    List<Animal> animals = new ArrayList<>(20);
                    FoodStore foodStore = new FoodStore();
                    currentEnclosure = new Enclosure(animals, foodStore, waste);
                    addEnclosure(currentEnclosure);  // Add enclosure to the zoo
                } else if (line.startsWith("steak:") || line.startsWith("hay:") || line.startsWith("celery:") || line.startsWith("fish:")) {
                    String[] parts = line.split(":");
                    String type = parts[0];
                    int quantity = Integer.parseInt(parts[1]);
                    Food food = Food.valueOf(type.toUpperCase());

                    if (currentEnclosure != null) {
                        currentEnclosure.getFoodStore().addFood(food, quantity);
                    } else {
                        generalFoodStore.addFood(food, quantity);
                    }
                } else if (line.startsWith("lion:") || line.startsWith("tiger:") || line.startsWith("bear:")) {
                    if (currentEnclosure == null) {
                        throw new AnimalWithoutEnclosureException("Animal must be defined inside an enclosure.");
                    }

                    String[] parts = line.split(":")[1].split(",");
                    char gender = parts[0].charAt(0);
                    int age = Integer.parseInt(parts[1]);
                    int health = Integer.parseInt(parts[2]);

                    Animal animal = null;
                    if (line.startsWith("lion:")) {
                        animal = new Lion(age, gender, health, currentEnclosure);
                    } else if (line.startsWith("tiger:")) {
                        animal = new Tiger(age, gender, health, currentEnclosure);
                    } else if (line.startsWith("bear:")) {
                        animal = new Bear(age, gender, health, currentEnclosure);
                    }

                    if (animal != null) {
                        currentEnclosure.addAnimal(animal);
                    }
                } else if (line.startsWith("playZookeeper:")) {
                    if (currentEnclosure == null) {
                        throw new ZooKeeperWithoutEnclosureException("Zookeeper must be defined inside an enclosure.");
                    }
                    PlayZooKeeper playZooKeeper = new PlayZooKeeper(currentEnclosure);
                    zooKeepers.add(playZooKeeper);
                } else if (line.startsWith("physioZookeeper:")) {
                    if (currentEnclosure == null) {
                        throw new ZooKeeperWithoutEnclosureException("Zookeeper must be defined inside an enclosure.");
                    }
                    PhysioZooKeeper physioZooKeeper = new PhysioZooKeeper(currentEnclosure);
                    zooKeepers.add(physioZooKeeper);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AnimalWithoutEnclosureException e) {
            e.printStackTrace();
            System.out.println("Animal declared without enclosure");;
        }catch (ZooKeeperWithoutEnclosureException e){
            e.printStackTrace();
            System.out.println("ZooKeeper declared without enclosure");
        }
    }

    public static void main(String[] args) {
        loadConfiguration(ZOO_DATA_FILE);
        go();
    }
}
