package P01_vehicles;

public class Truck extends  Vehicles {
    private static final double SUMMER_MODE_PERMANENT_ON = 1.6;


    public Truck(double fuelQuantity, double fuelConsumationPerKm) {
        super(fuelQuantity, fuelConsumationPerKm);
    }

    @Override
    protected void setFuelConsumationPerKm(double fuelConsumationPerKm){
        super.setFuelConsumationPerKm(fuelConsumationPerKm +
                SUMMER_MODE_PERMANENT_ON);
    }


    @Override
    public void refuel(double fuelQuantity) {
        double realFuelQuantity = fuelQuantity - ((fuelQuantity * 5) / 100);
        super.refuel(realFuelQuantity);
    }
}
