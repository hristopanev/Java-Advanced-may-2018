import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class P07_ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, String>> students = new ArrayList<>();

        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split(" ", 3);

            String firstname = tokens[0];
            String lasrstname = tokens[1];
            String mark = tokens[2];

            Pair<String, String> student = new Pair<>(firstname + " " + lasrstname, mark);

            students.add(student);
        }
        students.stream()
                .filter(s -> s.getValue().contains("6"))
                .forEach(s -> System.out.println(String.format("%s", s.getKey())));
    }

}
