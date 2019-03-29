package model.boat;

import model.engine.Engine;

public class PowerBoat extends Motorboat {

private Engine secondEngine;

    public PowerBoat(String model, double weight, Engine engine, Engine secondEngine) {
        super(model, weight, engine);
        this.secondEngine = secondEngine;
    }

    public Engine getSecondEngine() {
        return this.secondEngine;
    }

    public void setSecondEngine(Engine secondEngine) {
        this.secondEngine = secondEngine;
    }
}
