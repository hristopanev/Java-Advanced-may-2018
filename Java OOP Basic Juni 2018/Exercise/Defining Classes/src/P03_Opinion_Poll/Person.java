package P03_Opinion_Poll;

public class Person implements Comparable<Person>{
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
    public int compareTo(Person p){
        return this.getName().compareTo(p.getName());
    }
}

