package farm;

public class Tiger extends Felime {


    public Tiger(String name, String type, double weight, String livingRegion) {
        super(name, type, weight,  livingRegion);
    }

    @Override
    public void eat(Food food){
        if (food.getClass().getSimpleName().equalsIgnoreCase("Meat")){
            super.eat(food);
        }else {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }
}
