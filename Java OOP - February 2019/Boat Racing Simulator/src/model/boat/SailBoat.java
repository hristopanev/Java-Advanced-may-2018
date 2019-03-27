package model.boat;

public class SailBoat extends Boat {

    private int sailEfficiency;

    public SailBoat(String model, double weight, int sailEfficiency) {
        super(model, weight);
        this.sailEfficiency = sailEfficiency;
    }

    public int getSailEfficiency() {
        return this.sailEfficiency;
    }

    public void setSailEfficiency(int sailEfficiency) {
        this.sailEfficiency = sailEfficiency;
    }
}
