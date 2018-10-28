package demo;

public interface Rentable extends Car {
   Integer getMinRentDay();
   Double getPricePerDay();

    @Override
    String getModel();

    @Override
    String getColoer();

    @Override
    int getHorsePower();
}
