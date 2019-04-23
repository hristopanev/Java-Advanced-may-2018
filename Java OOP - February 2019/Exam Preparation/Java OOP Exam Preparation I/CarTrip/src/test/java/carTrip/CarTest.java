package carTrip;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    private final String DEFAULT_MODEL = "Ford";
    private final double DEFAULT_CAPACITY = 55;
    private final double DEFAULT_FUEL_AMOUNT = 40;
    private final double DEFAULT_FUEL_CONSUMPTION = 8;

    private Car car;

    @Before
    public void setUp() throws Exception {
        this.car = new Car(DEFAULT_MODEL, DEFAULT_CAPACITY, DEFAULT_FUEL_AMOUNT, DEFAULT_FUEL_CONSUMPTION);
    }

    @Test
    public void getModel() {
        this.car.getModel();
    }

    @Test
    public void setModel() {
        this.car.setModel("Porshe");
        assertEquals("Porshe", this.car.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setModelExceptionIsNull() {
        String newCarName = null;

        this.car.setModel(newCarName);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setModelExceptionIsEmpty() {
        String newCarName = "";

        this.car.setModel(newCarName);
    }


    @Test
    public void getTankCapacity() {

        assertEquals(55, this.car.getTankCapacity(), 0.0);
    }

    @Test
    public void setTankCapacity() {

        this.car.setTankCapacity(80);

        assertEquals(80, this.car.getTankCapacity(), 0.0);
    }

    @Test
    public void getFuelAmount() {

        assertEquals(40, this.car.getFuelAmount(), 0.0);
    }

    @Test
    public void setFuelAmount() {
        this.car.setFuelAmount(45);

        assertEquals(45, this.car.getFuelAmount(), 0.0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void setFuelAmountThrowException() {
        this.car.setFuelAmount(80);
    }

    @Test
    public void getFuelConsumptionPerKm() {
        assertEquals(8, this.car.getFuelConsumptionPerKm(), 0.0);
    }

    @Test
    public void setFuelConsumptionPerKm() {
        this.car.setFuelConsumptionPerKm(10);

        assertEquals(10, this.car.getFuelConsumptionPerKm(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFuelConsumptionPerKmThrowException() {
        double consumption = 0;
        car.setFuelConsumptionPerKm(consumption -1);

        assertEquals(consumption, this.car.getFuelConsumptionPerKm(), 0.1);
    }

    @Test(expected = IllegalStateException.class)
    public void driveShouldThrowIfNotEnoughFuel(){
        this.car.drive(2000000);
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
    public void refuelThrowException() {
        car.refuel(50);
    }

    @Test
    public void refuel() {
        car.refuel(5);
    }
}