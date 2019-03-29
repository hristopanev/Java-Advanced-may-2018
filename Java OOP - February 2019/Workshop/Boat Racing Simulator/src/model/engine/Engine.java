package model.engine;

import model.Model;

public abstract class Engine implements Model {
    private String model;
    private double output;
    private int horsepower;
    private int displacement;

    public Engine(String model, int horsepower, int displacement) {
        this.model = model;
        this.horsepower = horsepower;
        this.displacement = displacement;


        this.output = this.calculateOutput();
    }

    abstract double calculateOutput();

    @Override
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getOutput() {
        return this.output;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getDisplacement() {
        return this.displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }
}
