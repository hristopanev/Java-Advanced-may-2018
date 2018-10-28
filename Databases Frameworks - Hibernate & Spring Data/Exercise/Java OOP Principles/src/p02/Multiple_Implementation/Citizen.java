package p02.Multiple_Implementation;

public class Citizen implements Identifiable, Birthable, Person {

    private String name;
    private int age;
    private String id;
    private String birthdate;

    public Citizen(String name, int age, String id, String birthdate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthdate = birthdate;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getId() {
        return this.id;
    }

    public String getBirthdate() {
        return this.birthdate;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
