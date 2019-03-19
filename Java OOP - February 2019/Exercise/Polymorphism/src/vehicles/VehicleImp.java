package vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImp implements Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public VehicleImp(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);
        this.tankCapacity = tankCapacity;
    }


    protected void setFuelConsumption(double fuelConsumption){
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String drive(double distance){
        double fuelNeeded = distance * this.fuelConsumption;
        DecimalFormat df = new DecimalFormat("#.##");
        String result ="needs refueling";

        if (this.fuelQuantity >= fuelNeeded){
            result = String.format("travelled %s km", df.format(distance));
            this.fuelQuantity -= fuelNeeded;
        }

        return result;
    }

    @Override
    public void refuel(double liters){
        if (liters <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        double fuel = this.fuelQuantity + liters;
        if (fuel > tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
