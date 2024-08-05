package food;

import java.util.HashMap;
import java.util.Map;

public class FoodStore {

    private Food foodType;

    private static final Map<String, Integer> foodToCount = new HashMap<>();

    public void addFood(String food, Integer count){

        for(String meal : foodToCount.keySet()){
            if(meal.equals(food)){
                Integer newCount = foodToCount.get(meal) + count;
                foodToCount.put(food, newCount);
            }
        }
    }

    public void takeFood(String food){

        for(String meal : foodToCount.keySet()){
            if(meal.equals(food)){
                Integer newCount = foodToCount.get(meal) - 1;
                foodToCount.put(food, newCount);
            }
        }
    }

    public Food getFoodType() {
        return foodType;
    }
}
