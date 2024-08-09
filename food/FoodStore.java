package food;

import zookeeper.ZooKeeper;

import java.util.HashMap;
import java.util.Map;

public class FoodStore {

    private Food foodType;

    private Map<Food, Integer> foodToCount = new HashMap<>();

    public void addFood(Food food, Integer count) {

        foodToCount.put(food, foodToCount.getOrDefault(food, 0) + count);
    }


    //used by animals to eat
    public void takeFood(Food food) {
        if(foodToCount.containsKey(food)){
            int currentCount = foodToCount.get(food);
            if(currentCount > 0){
                foodToCount.put(food, currentCount - 1);
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
            movedQuantity += quantityToMove;

            destinationStore.addFood(food, quantityToMove);
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
}
