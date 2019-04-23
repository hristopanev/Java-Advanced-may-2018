package P03_Opinion_Poll;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();
        int counter = Integer.parseInt(reader.readLine());

        while (counter-- > 0) {

            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            if (age > 30) {
               Person person = new Person(name, age);
                people.add(person);
            }
        }

        people.stream()
                .sorted((s1, s2) -> {
                    return s1.getName().compareTo(s2.getName());
                })
                .forEach(System.out::println);


    }


}
