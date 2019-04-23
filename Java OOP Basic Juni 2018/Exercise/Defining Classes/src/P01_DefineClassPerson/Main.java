package P01_DefineClassPerson;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws Exception {
        Class person = Person.class;

        Field[] fields = person.getDeclaredFields();

        System.out.println(fields.length);

        Person person1 = new Person("Pesho", 20);
        Person person2 = new Person("Gosho", 18);
        Person person3 = new Person("Stamat", 43);

    }
}
