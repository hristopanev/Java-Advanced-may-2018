package p01.Define_an_Interface_Person;

public class Citizen implements Person {

        private String name;
        private int age;

    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
