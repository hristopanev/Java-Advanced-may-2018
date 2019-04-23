import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P01_StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Map<String, List<Pair<String, String>>> students = new HashMap<>();

        String neededGroup = "2";

        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split(" ");

            String firstName = tokens[0];
            String lastName = tokens[1];
            String group = tokens[2];

            Pair<String, String> name = new Pair<>(firstName, lastName);

            List<Pair<String, String>> names = new ArrayList<>();

            if (students.containsKey(group)){
                names = students.get(group);
            }

            names.add(name);
            students.putIfAbsent(group, names);

        }

        students.entrySet().stream()
                .filter(x -> x.getKey().equals(neededGroup))
                .forEach(x -> x.getValue().stream()
                        .sorted((s1, s2) -> s1.getKey().compareTo(s2.getKey()))
                        .forEach(s -> System.out.println(String.format("%s %s", s.getKey(), s.getValue()))));

    }
}
