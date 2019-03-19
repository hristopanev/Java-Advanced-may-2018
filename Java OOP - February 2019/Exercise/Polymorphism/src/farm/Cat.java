package farm;

public class Cat extends Felime {
    private String breed;

    public Cat(String name, String type, double weight, String livingRegion, String breed) {
        super(name, type, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.insert(super.toString().indexOf(",")+ 2, this.breed + ", ");
        return sb.toString();
    }
}
