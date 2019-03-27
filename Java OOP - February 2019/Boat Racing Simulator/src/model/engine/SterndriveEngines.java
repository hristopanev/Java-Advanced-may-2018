package model.engine;

public class SterndriveEngines extends Engine {
    public SterndriveEngines(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    double calculateOutput() {
        return this.getHorsepower() * 7 + this.getDisplacement();
    }
}
