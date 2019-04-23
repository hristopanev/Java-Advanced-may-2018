package P10_GroupByGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P10_GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split(" ");

            String firstName = tokens[0];
            String lastName = tokens[1];
            int group = Integer.parseInt(tokens[2]);

            String fullName = firstName + " " + lastName;

            Person person = new Person(fullName, group);

            people.add(person);

        }

        Map<Integer, List<Person>> peopleByGroup = people.stream()
                .collect(Collectors.groupingBy(Person::getGroup));

        peopleByGroup.forEach((key, value) ->
                System.out.println(
                        String.format("%d - %s", key,
                                value.stream().map(Person::getName)
                                        .collect(Collectors.joining(", ")))));
    }
}

class Person{
    String name;
    int group;

    public String getName() {
        return name;
    }

    public int getGroup() {
        return group;
    }

    public Person(String name, int group) {
        this.name = name;
        this.group = group;
    }
}
