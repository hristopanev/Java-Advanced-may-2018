package P01_sort_by_Name_and_Age;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        while (count-- > 0){
            String[] info = reader.readLine().split("\\s+");

            Person person = new Person(info[0], info[1], Integer.parseInt(info[2]));
            people.add(person);
        }

        people.sort((firstPerson, secondPerson) -> {
           int comp  = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());
           if (comp == 0){
               return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
           }
           return comp;
        });

        people.forEach(System.out::println);

    }
}
