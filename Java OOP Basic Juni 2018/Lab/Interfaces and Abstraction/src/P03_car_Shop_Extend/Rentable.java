package P03_car_Shop_Extend;

public interface Rentable extends Car {

    Integer getMinRentDay();
    Double getPricePerDay();
}
