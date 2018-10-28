package p06.Birday_Celebration;


public class Pet implements Birthable {
    private String name;
    private String birthday;

    public Pet(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String getBirthdate() {
        return this.birthday;
    }

    @Override
    public boolean isBornIn(String year) {
        return this.birthday.endsWith(year);
    }

}
