package heroRepository;

public class Item {

    //strength, agility,  intelligence

    private int strength;
    private int agility;
    private int intelligence;

    public Item(int strength, int agility, int intelligence) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getAgility() {
        return this.agility;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();


        sb.append(String.format("  *  Strength: %d%n  *  Agility: %d%n  *  Intelligence: %d",
                this.strength, this.agility, this.intelligence));

        return sb.toString();

    }
}
