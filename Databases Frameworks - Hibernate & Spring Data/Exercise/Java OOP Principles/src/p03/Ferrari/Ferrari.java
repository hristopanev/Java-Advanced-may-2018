package p03.Ferrari;

public class Ferrari implements Car {

    private String brand;
    private String model;
    private String driver;

    public Ferrari(String driver) {
        this.brand = "Ferrari";
        this.model = "488-Spider";
        this.driver = driver;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }


    public String getDriver() {
        return this.driver;
    }

    @Override
    public String getStart() {
        return "Zadu6avam sA!";
    }

    @Override
    public String getStop() {
        return "Brakes!";
    }


    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.model,this.getStop(),this.getStart(),this.driver);
    }


}
