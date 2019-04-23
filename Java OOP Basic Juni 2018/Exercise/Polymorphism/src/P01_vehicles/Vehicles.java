package P01_vehicles;

public class Vehicles {
    private double fuelQuantity;
    private double fuelConsumationPerKm;

    protected Vehicles(double fuelQuantity, double fuelConsumationPerKm){
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumationPerKm(fuelConsumationPerKm);
    }

    private void setFuelQuantity(double fuelQuantity){
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumationPerKm(double fuelConsumationPerKm){
        this.fuelConsumationPerKm = fuelConsumationPerKm;
    }


    public boolean drive(double distance){
        double neededFuel = distance * this.fuelConsumationPerKm;

        if (this.fuelQuantity < neededFuel){
            return false;
        }

        this.fuelQuantity -= neededFuel;
        return true;
    }

    public void refuel(double fuelQuantity){
        this.fuelQuantity += fuelQuantity;
    }

    @Override
    public String toString() {
        return String.format("", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
