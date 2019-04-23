package P04_fragile_Base_Class;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Animal {
    protected List<Food> footEaten;

    public Animal(){
        this.footEaten = new ArrayList<>();
    }

    public void eat(Food food){
        this.footEaten.add(food);
    }

    public  void eatAll(Food[] food){
        for (Food food1 : food) {
            this.eat(food1);
        }
    }
}
