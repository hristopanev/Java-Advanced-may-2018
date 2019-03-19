package farm;

public class Zebra extends Mammal {


    public Zebra(String name, String type, double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "Zs";
    }
}
