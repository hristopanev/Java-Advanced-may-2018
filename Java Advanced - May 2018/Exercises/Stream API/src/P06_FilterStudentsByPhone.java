import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P06_FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, String>> students = new ArrayList<>();

        String line;
        Student(reader, students);
        students.stream()
                .filter(s -> s.getValue().startsWith("02") || s.getValue().startsWith("+3592"))
                .forEach(s -> System.out.println(String.format("%s", s.getKey())));
    }

    static void Student(BufferedReader reader, List<Pair<String, String>> students) throws IOException {
        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split(" ");

            String firstName = tokens[0];
            String lastName = tokens[1];
            String phone = tokens[2];

            Pair<String, String> student = new Pair<>(firstName + " " + lastName, phone);

            students.add(student);


        }
    }
}
