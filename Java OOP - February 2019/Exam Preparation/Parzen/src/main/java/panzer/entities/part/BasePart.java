package panzer.entities.part;

import panzer.contracts.Modelable;
import panzer.contracts.Part;

import java.math.BigDecimal;

public abstract class BasePart implements Part, Modelable {

    private String model;
    private double weight;
    private BigDecimal price;

    protected BasePart(String model, double weight, BigDecimal price) {
        this.model = model;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());


        return super.toString();
    }
}
