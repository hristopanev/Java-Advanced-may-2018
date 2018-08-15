package P03_Opinion_Poll;

public class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, this.age);
    }
}

