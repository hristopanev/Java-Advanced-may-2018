package p05.Border_Control;

public class Robot extends Identifiable {
    private String model;

    public Robot(String model, String id) {
        super(id);
        this.model = model;
    }
}
