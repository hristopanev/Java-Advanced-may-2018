package carConstructors;

public class Car {
    private String make;
    private String model;
    private Integer horsePower;

    public static final String undefinedValue = "unknown";


    public Car(String make, String model, Integer horsePower) {
        this(make);
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car(String make) {
        this();
        this.make = make;
    }

    public Car() {
        this.make = undefinedValue;
        this.model = undefinedValue;
        this.horsePower = -1;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getHorsePower() {
        return this.horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.",
                this.getMake(), this.getModel(), this.getHorsePower());
    }
}
