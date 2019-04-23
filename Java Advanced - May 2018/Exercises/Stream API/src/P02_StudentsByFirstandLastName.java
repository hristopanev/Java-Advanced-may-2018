import javafx.util.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P02_StudentsByFirstandLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, String>> students = new ArrayList<>();

        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split(" ");

            String firstName = tokens[0];
            String lastName = tokens[1];

            Pair<String, String> name = new Pair<>(firstName, lastName);

            List<Pair<String, String>> student = new ArrayList<>();

            students.add(name);
        }

        students.stream()
                .filter(s -> s.getValue().compareTo(s.getKey()) > 0)
                .forEach(s -> System.out.println(String.format("%s %s", s.getKey(), s.getValue())));
    }
}
