package farm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String name, String type, double weight, String livingRegion) {
        super(name, type, weight);
        this.livingRegion = livingRegion;
    }

    @Override
    public void eat(Food food){
        if (food.getClass().getSimpleName().equals("Vegetable")){
            super.setFoodEaten(food.getQuantity());
        }else {
            String animalType = this.getClass().getSimpleName()
                    .equalsIgnoreCase("Mouse") ? "Mice" : "Zebras";

            throw new IllegalArgumentException(
                    animalType + "are not eating that type of food!");
        }
    }


    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");

        return String.format("%s[%s, %s, %s, %d]",
               this.getClass().getSimpleName(), this.getName(),
                df.format(this.getWeight()), this.livingRegion, this.getFoodEaten());
    }
}
