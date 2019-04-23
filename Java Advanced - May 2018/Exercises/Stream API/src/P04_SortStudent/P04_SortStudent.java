package P04_SortStudent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P04_SortStudent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> students = new ArrayList<>();

        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens= line.split(" ");

            String firstName = tokens[0];
            String lasstName = tokens[1];

            Student student = new Student(firstName, lasstName);

            students.add(student);

        }
        students.stream()
                .sorted((s1, s2) -> {
                    int comparatorByLastName =  s1.getLastName().compareTo(s2.getLastName());

                    if (comparatorByLastName != 0){
                        return  comparatorByLastName;
                    }
                    int comparatorByFirstName = s2.getFirstName().compareTo(s1.getFirstName());

                    return comparatorByFirstName;
                })
                .forEach(System.out::println);
    }
}

class Student{
    String firstName;
    String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}

