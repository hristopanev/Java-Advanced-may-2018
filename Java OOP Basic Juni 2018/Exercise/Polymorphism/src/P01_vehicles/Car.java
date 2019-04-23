package P01_vehicles;

public class Car extends Vehicles {
    private static final double SUMMER_MODE_PERMANENT_ON = 0.9;


    public Car(double fuelQuantity, double fuelConsumationPerKm) {
        super(fuelQuantity, fuelConsumationPerKm);
    }

    @Override
    protected void setFuelConsumationPerKm(double fuelConsumationPerKm){
        super.setFuelConsumationPerKm(fuelConsumationPerKm +
                SUMMER_MODE_PERMANENT_ON);
    }
}
