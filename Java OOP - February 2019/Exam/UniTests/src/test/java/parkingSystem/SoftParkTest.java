package parkingSystem;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class SoftParkTest {

    private SoftPark softPark;
    private Car car;

    @Before
    public void setUp() throws Exception {
        this.softPark = new SoftPark();
        softPark.getParking();

    }

    @Test
    public void getPark(){
        int result = softPark.getParking().size();
        assertEquals(12, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarThrowException() {
        softPark.parkCar("FO", car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarThrowExceptionWhenNull() {
        softPark.parkCar("FO", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pakCarExistAlreadyTanked() {
        car = new Car("Opel", "1234");
        softPark.parkCar("A1", car);
        softPark.parkCar("A1", car);
    }

    @Test(expected = IllegalStateException.class)
    public void pakCarExist(){
        car = new Car("BMW", "1234");
        car = new Car("BMW", "1234");
        softPark.parkCar("A1", car);
        softPark.parkCar("A2", car);

    }

    @Test
    public void carPark() {
        car = new Car("Opel", "1234");
        String result = softPark.parkCar("A1", car);

        assertEquals("Car:1234 parked successfully!", result);
    }


    @Test
    public void removeCar() {
        car = new Car("Opel", "1234");
        softPark.parkCar("A1", car);
        String result = softPark.removeCar("A1", car);

        assertEquals("Remove car:1234 successfully!", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarThrowException() {
        car = new Car("Opel", "1234");
        softPark.parkCar("A1", car);
        softPark.removeCar("sd", car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarThrowExceptionNull() {
        car = new Car("Opel", "1234");
        softPark.parkCar("A1", car);
        softPark.removeCar("A1", null);
    }
}