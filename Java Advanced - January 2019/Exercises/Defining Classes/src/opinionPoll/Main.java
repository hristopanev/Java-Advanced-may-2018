package opinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Person> people = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {

            String[] tokens = scanner.nextLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .filter(p -> p.getAge() > 30)
                .forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));
    }
}
