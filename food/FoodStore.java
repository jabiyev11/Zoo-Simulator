package food;

import zookeeper.ZooKeeper;

import java.util.HashMap;
import java.util.Map;

public class FoodStore {

    private Food foodType;

    private Map<String, Integer> foodToCount = new HashMap<>();

    public void addFood(String food, Integer count) {

        foodToCount.put(food, foodToCount.getOrDefault(food, 0) + count);
    }

    public Integer takeUpTo20Food(FoodStore destinationStore) {

        Integer totalQuantityToMove = 20;
        Integer movedQuantity = 0;

        for(Map.Entry<String, Integer> entry : foodToCount.entrySet()){
            String food = entry.getKey();
            Integer currentCount = entry.getValue();

            if(movedQuantity >= totalQuantityToMove)
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
}
