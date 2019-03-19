package farm;

public abstract class Felime extends Mammal {

    public Felime(String name, String type, double weight, String livingRegion) {
        super(name, type, weight,  livingRegion);
    }

    @Override
    public void eat(Food food){
        super.setFoodEaten(food.getQuantity());
    }
}
