package builder;

public class CreateBoatEngine {
    private String model;
    private double horsePower;
    private double displacement;
    private String type;


    public CreateBoatEngine withModel(String model){
        this.model = model;

        return this;
    }

    public CreateBoatEngine withHorsepower(String horsepower){
        this.horsePower = horsePower;

        return this;
    }
}
