package demo;

public class Vehicles {
    private String type;
    private String model;
    private String color;
    private int horsepower;

    public Vehicles(String type, String model, String color, int horsepower) {
        this.setType(type);
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public String getType() {
        return this.type;
    }

    private void setType(String type) {
        type = type.replace(type.charAt(0), Character.toUpperCase(type.charAt(0)));
        this.type = type;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return String.format("Type: %s%n" +
                                "Model: %s%n" +
                                "Color: %s%n" +
                                "Horsepower: %d",
                this.getType(), this.getModel(), this.getColor(), this.getHorsepower());
    }



}
