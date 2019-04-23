package P03_validation_Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, NullPointerException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        while (count-- > 0) {

            String[] info = reader.readLine().split("\\s+");

            Person person = null;

            try {
                person = new Person(info[0], info[1], Integer.parseInt(info[2]),
                        Double.parseDouble(info[3]));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            if (people != null) {
                people.add(person);
            }

        }
        int bonus = Integer.parseInt(reader.readLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person);
        }
    }
}
