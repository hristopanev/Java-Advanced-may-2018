package demo;

public interface Car {
    static final int Tires = 4;
    String getModel();
    String getColoer();
    int getHorsePower();

    Integer minRentDay();

    Double pricePerDay();
}
