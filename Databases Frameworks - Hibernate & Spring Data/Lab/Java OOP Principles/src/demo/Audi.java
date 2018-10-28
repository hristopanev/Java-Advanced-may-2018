package demo;

public class Audi implements Rentable {

    private String model;
    private String coloer;
    private int minRentDay;
    private double pricePerDay;
    private int hoursePower;

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay();
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay();
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColoer() {
        return this.coloer;
    }

    @Override
    public int getHorsePower() {
        return this.hoursePower;
    }

    @Override
    public Integer minRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double pricePerDay() {
        return this.pricePerDay;
    }
}
