package food;

import zookeeper.ZooKeeper;

import java.util.HashMap;
import java.util.Map;

public class FoodStore {

    private Food foodType;

    private Map<Food, Integer> foodToCount = new HashMap<>();

    public void addFood(Food food, Integer count) {

        foodToCount.put(food, foodToCount.getOrDefault(food, 0) + count);
        System.out.println(count + " " + food + " added to food store");
    }


    //used by animals to eat
    public void takeFood(Food food) {
        if(foodToCount.containsKey(food)){
            int currentCount = foodToCount.get(food);
            if(currentCount > 0){
                foodToCount.put(food, currentCount - 1);
                System.out.println("One " + food + " taken from the food store");
            }else {
                System.out.println("No more " + food + " left to take");
            }
        }else{
            System.out.println(food + " is not available in the food store");
        }

    }

    //used by zookeepers to fulfill foodStore
    public Integer takeUpTo20Food(FoodStore destinationStore) {

        Integer totalQuantityToMove = 20;
        Integer movedQuantity = 0;

        for (Map.Entry<Food, Integer> entry : foodToCount.entrySet()) {
            Food food = entry.getKey();
            Integer currentCount = entry.getValue();

            if (movedQuantity >= totalQuantityToMove)
                break;

            Integer quantityToMove = Math.min(currentCount, totalQuantityToMove - movedQuantity);
            foodToCount.put(food, currentCount - quantityToMove);
            System.out.println(quantityToMove + " " + food + " moved from general food store by Zookeeper");
            movedQuantity += quantityToMove;

            destinationStore.addFood(food, quantityToMove);
            System.out.println("Zookeeper moved foods to " + destinationStore);
        }


        return movedQuantity;
    }

    public Food getFoodType() {
        return foodType;
    }

    public Integer getCountOfFoods() {
        return foodToCount.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public boolean hasFood(Food food){
        return foodToCount.getOrDefault(food, 0) > 0;
    }


    @Override
    public String toString() {
        return "FoodStore{" +
                "foodType=" + foodType +
                ", foodToCount=" + foodToCount +
                '}';
    }
}
