package carTrip;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    private final String DEFAULT_MODEL = "Ford";
    private final double DEFAULT_CAPACITY = 50;
    private final double DEFAULT_FUEL_AMOUNT = 10;
    private final double DEFAULT_FUEL_CONSUMPTION = 8;
    private Car car;

    @Before
    public void setUp() throws Exception {
        this.car = new Car(DEFAULT_MODEL, DEFAULT_CAPACITY, DEFAULT_FUEL_AMOUNT, DEFAULT_FUEL_CONSUMPTION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setModelIsNull() {
        this.car.setModel(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setModelIsEmptyString() {
        this.car.setModel("");
    }

    @Test
    public void setModelIsCorrectly() {
        final String newModel = "Mercedes";
        this.car.setModel(newModel);

        assertEquals(newModel, this.car.getModel());
    }

    @Test
    public void getTankCapacity() {
        assertEquals(DEFAULT_CAPACITY, this.car.getTankCapacity(), 0.1);
    }

    @Test
    public void setTankCapacity() {
        final double newCapacity = 60;
        this.car.setTankCapacity(newCapacity);

        assertEquals(newCapacity, this.car.getTankCapacity(), 0.1);
    }

    @Test
    public void getFuelAmount() {
        assertEquals(DEFAULT_FUEL_AMOUNT, this.car.getFuelAmount(), 0.1);
    }

    @Test
    public void setFuelAmount() {
        final double newAmount = 15;
        this.car.setFuelAmount(newAmount);

        assertEquals(newAmount, this.car.getFuelAmount(), 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFuelAmountShouldException() {
        final double newAmount = 50;
        this.car.setFuelAmount(50 + 1);

        assertEquals(newAmount, this.car.getFuelAmount(), 0.1);

    }
    @Test
    public void setFuelConsumption() {
        final double newConsumption = 10;
        this.car.setFuelConsumptionPerKm(newConsumption);

        assertEquals(newConsumption, this.car.getFuelConsumptionPerKm(), 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFuelConsumptionThrowException() {
        double consumption = 0;
        car.setFuelConsumptionPerKm(consumption -1);

        assertEquals(consumption, this.car.getFuelConsumptionPerKm(), 0.1);
    }

    @Test(expected = IllegalStateException.class)
    public void driveShouldThrowIfNotEnoughFuel(){
        this.car.drive(2.0);
    }

    @Test
    public void drive(){
        this.car.drive(1);

        assertEquals(DEFAULT_FUEL_AMOUNT - DEFAULT_FUEL_CONSUMPTION, this.car.getFuelAmount(), 0.1);
    }

    @Test
    public void driveReturnCorrectResult(){
        String result = this.car.drive(1);

        assertEquals("Have a nice trip", result);
    }

    @Test(expected = IllegalStateException.class)
    public void refuelShouldThrow(){
        this.car.refuel(DEFAULT_CAPACITY + 1);
    }

    @Test
    public void refuelShouldWork(){
        double amount = 10.0;
        this.car.refuel(amount);

        assertEquals(amount + DEFAULT_FUEL_AMOUNT, this.car.getFuelAmount(), 0.0);
    }
}