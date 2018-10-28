package demo;

public abstract class BaseCar implements  Car {

    private String model;
    private String coloer;
    private int HorsePower;

    public BaseCar(String model) {
        setModel(model);
    }


    @Override
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getColoer() {
        return this.coloer;
    }

    public void setColoer(String coloer) {
        this.coloer = coloer;
    }

    @Override
    public int getHorsePower() {
        return this.HorsePower;
    }

    public void setHorsePower(int horsePower) {
        HorsePower = horsePower;
    }
}
