package P04_say_Hello;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>(){{
            add(new Bulgarian("Ivan"));
            add(new European("Peter"));
            add(new Chinese("Ping"));
        }};

        for (Person person : people) {
            printPerson(person);
        }

    }

    private static void printPerson(Person person) {
        System.out.println(person.sayHello());
    }
}
