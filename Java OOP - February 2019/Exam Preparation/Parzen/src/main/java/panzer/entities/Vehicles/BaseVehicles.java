package panzer.entities.Vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseVehicles implements Vehicle {

    private String model;
    private double weight;
    private BigDecimal price;
    private int attack;
    private int defence;
    private int hitPoints;
    private Assembler vehicleAssembler;
    private List<Part> parts;

    protected BaseVehicles(String model, double weight, BigDecimal price, int attack, int defence, int hitPoints) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defence = defence;
        this.hitPoints = hitPoints;
        this.vehicleAssembler = new VehicleAssembler();
        this.parts = new ArrayList<>();
    }

    @Override
    public double getTotalWeight() {
        return this.vehicleAssembler.getTotalWeight() + this.weight;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.vehicleAssembler.getTotalPrice().add(this.price);
    }

    @Override
    public long getTotalAttack() {
        return this.vehicleAssembler.getTotalAttackModification() + this.attack;
    }

    @Override
    public long getTotalDefense() {
        return this.vehicleAssembler.getTotalDefenseModification() + this.defence;
    }

    @Override
    public long getTotalHitPoints() {
        return this.vehicleAssembler.getTotalHitPointModification() + this.hitPoints;
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
            this.vehicleAssembler.addArsenalPart(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
            this.vehicleAssembler.addShellPart(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.vehicleAssembler.addEndurancePart(endurancePart);
    }

    @Override
    public List<Part> getParts() {
        return this.parts;
    }

    @Override
    public String getModel() {
        return this.model;
    }


}
