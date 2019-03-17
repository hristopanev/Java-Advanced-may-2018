package multipleImplementation;

public class Pet implements  Birthable, Person {

    private String birthDate;
    private String name;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return 0;
    }


}
