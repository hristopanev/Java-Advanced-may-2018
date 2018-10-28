package p06.Birday_Celebration;


public class Citizen extends Identifiable implements Birthable {
    private String name;
    private Integer age;
    private String birthdate;

    public Citizen(String name, Integer age, String id, String birthdate) {
        super(id);
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
    }



    @Override
    public String getBirthdate() {
        return this.birthdate;
    }

    @Override
    public boolean isBornIn(String year) {
        return this.birthdate.endsWith(year);
    }
}
