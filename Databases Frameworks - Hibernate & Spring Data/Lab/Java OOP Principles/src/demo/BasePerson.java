package demo;

public abstract class BasePerson implements Person {
    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public BasePerson(String name) {
        setName(name);
    }

    @Override
    public String getName() {
        return null;
    }


}
