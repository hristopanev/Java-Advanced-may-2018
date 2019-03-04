package sortByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        while (n-- > 0){
            String[] tokens = reader.readLine().split("\\s+");
            people.add(new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2])));
        }

        people.stream().sorted((f,s) -> {
            int compResult = f.getFirstName().compareTo(s.getFirstName());

            if (compResult == 0){
                compResult = f.getAge().compareTo(s.getAge());
            }

            return compResult;
        }).forEach(System.out::println);
    }
}
