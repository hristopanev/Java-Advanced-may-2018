package p05.Border_Control;

public class Citizen extends  Identifiable{
    private String name;
    private Integer age;

    public Citizen(String name, Integer age, String id) {
        super(id);
        this.name = name;
        this.age = age;
    }
}
