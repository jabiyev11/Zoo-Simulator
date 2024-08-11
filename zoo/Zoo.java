package zoo;

import animal.Lion;
import enclosure.Enclosure;
import food.Food;
import food.FoodStore;
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
        for(Enclosure enclosure : enclosures){
            enclosure.aMonthPasses();
        }

        for(ZooKeeper zooKeeper : zooKeepers){
            zooKeeper.aMonthPasses();
        }

        generalFoodStore.addFood(getRandomFood(), random.nextInt(1, 100));
    }

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
                    Zoo zoo = new Zoo();
                } else if (line.startsWith("enclosure:")) {
                    int waste = Integer.parseInt(line.split(":")[1]);
                    currentEnclosure = new Enclosure();
                    currentEnclosure.setWaste(waste);
                    addEnclosure(currentEnclosure);
                } else if (line.startsWith("steak:") || line.startsWith("hay:") || line.startsWith("celery:")) {
                    String[] parts = line.split(":");
                    String type = parts[0];
                    int quantity = Integer.parseInt(parts[1]);

                    Food food = Food.valueOf(type.toUpperCase()); // Assuming Food is an enum
                    generalFoodStore.addFood(food, quantity);
                } else if (line.startsWith("lion:")) {
                    String[] parts = line.split(":")[1].split(",");
                    char gender = parts[0].charAt(0);
                    int age = Integer.parseInt(parts[1]);
                    int health = Integer.parseInt(parts[2]);
                    int enclosureIndex = Integer.parseInt(parts[3]);

                    Enclosure enclosure = enclosures[enclosureIndex - 1]; // Assuming 1-based indexing
                    Lion lion = new Lion(age, gender, health, enclosure);
                    enclosure.addAnimal(lion);
                } else if (line.startsWith("playZookeeper:")) {
                    ZooKeeper zooKeeper = new ZooKeeper(currentEnclosure);
                    zooKeepers.add(zooKeeper);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        loadConfiguration(ZOO_DATA_FILE);
        go();
    }
}
