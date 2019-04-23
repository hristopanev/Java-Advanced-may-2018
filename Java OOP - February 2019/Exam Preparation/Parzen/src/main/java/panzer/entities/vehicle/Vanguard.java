package panzer.entities.vehicle;


import java.math.BigDecimal;

public class Vanguard extends BaseVehicle {

    private String model;


    public Vanguard(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model, weight * 2, price,(int) (attack * 0.75), (int)(defense * 1.50),(int)(hitPoints * 1.75));
    }
}
