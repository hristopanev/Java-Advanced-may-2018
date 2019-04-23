package P05_say_Hello_Extend;


import P05_say_Hello_Extend.person.Person;
import P05_say_Hello_Extend.personimpl.Bulgarian;
import P05_say_Hello_Extend.personimpl.Chinese;
import P05_say_Hello_Extend.personimpl.European;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>(){{
            add(new Bulgarian("Ivan"));
            add(new European("John"));
            add(new Chinese("Po"));
        }};

        for (Person person : people) {
            printPerson(person);
        }

    }

    private static void printPerson(Person person) {
        System.out.println(person.sayHello());
    }
}
