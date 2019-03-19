package farm;

public class Mouse extends Mammal {
    public Mouse(String name, String type, double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public String  makeSound() {
        return "SQUEEEAAAK!";
    }
}
