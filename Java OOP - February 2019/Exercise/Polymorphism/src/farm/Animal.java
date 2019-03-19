package farm;

public abstract class Animal implements Feedabel, Soundable {
    private String name;
    private String type;
    private double weight;
    private int foodEaten;

    public Animal(String name, String type, double weight){
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.foodEaten = 0;
    }

    protected void setFoodEaten(int quantity){
        this.foodEaten = quantity;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getFoodEaten() {
        return this.foodEaten;
    }
}
