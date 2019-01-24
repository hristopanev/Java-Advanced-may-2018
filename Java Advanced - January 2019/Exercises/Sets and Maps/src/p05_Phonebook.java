import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new TreeMap<>();

        String line = scanner.nextLine();

        while (!line.equals("search")) {

            String[] tokens = line.split("-");
            String name = tokens[0];
            String number = tokens[1];

            phonebook.put(name, number);
            line = scanner.nextLine();
        }

        line = scanner.nextLine();
        while (!line.equals("stop")) {

            if (!phonebook.containsKey(line)) {
                System.out.printf("Contact %s does not exist.%n", line);
            } else {
                System.out.printf("%s -> %s%n", line, phonebook.get(line));
            }
            line = scanner.nextLine();
        }
    }
}
