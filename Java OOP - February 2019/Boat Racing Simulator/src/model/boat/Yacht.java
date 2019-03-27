package model.boat;

import model.engine.Engine;

public class Yacht extends  Motorboat {
    private double cargo;

    public Yacht(String model, double weight, Engine engine, double cargo) {
        super(model, weight, engine);
        this.cargo = cargo;
    }

    public double getCargo() {
        return this.cargo;
    }

    public void setCargo(double cargo) {
        this.cargo = cargo;
    }
}
