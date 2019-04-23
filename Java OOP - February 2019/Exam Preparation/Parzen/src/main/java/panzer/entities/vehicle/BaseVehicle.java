package panzer.entities.vehicle;

import panzer.contracts.Assembler;
import panzer.contracts.Modelable;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseVehicle implements Vehicle, Modelable {

    private String model;
    private double weight;
    private BigDecimal price;
    private int attack;
    private int defense;
    private int hitPoints;
    private Assembler vehicleAssembler;
    private List<Part> parts;

    protected BaseVehicle(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.vehicleAssembler = new VehicleAssembler();
        this.parts = new ArrayList<>();
    }

    @Override
    public String getModel() {
        return this.model;
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
        return this.vehicleAssembler.getTotalDefenseModification() + this.defense;
    }

    @Override
    public long getTotalHitPoints() {
        return this.vehicleAssembler.getTotalHitPointModification() + this.hitPoints;
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.parts.add(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.parts.add(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.parts.add(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() {
        return this.parts;
    }

    @Override
    public String toString() {
        //getClass().getSimpleName() + " " + this.getModel()
        StringBuilder sb = new StringBuilder();
        List<String> models = new ArrayList<>();

        for (Part part : parts) {
           models = Collections.singletonList(part.getModel());
        }
        String join = String.join(", ", models);

        sb.append(System.lineSeparator());
        sb.append("Total Weight: ").append(this.getTotalWeight()).append(System.lineSeparator());
        sb.append("Total Price: ").append(this.getTotalPrice()).append(System.lineSeparator());
        sb.append("Attack: ").append(this.getTotalAttack()).append(System.lineSeparator());
        sb.append("Defense: ").append(this.getTotalDefense()).append(System.lineSeparator());
        sb.append("HitPoints: ").append(this.getTotalHitPoints()).append(System.lineSeparator());
        sb.append("Parts: ").append(join);

        return sb.toString();
    }

}
