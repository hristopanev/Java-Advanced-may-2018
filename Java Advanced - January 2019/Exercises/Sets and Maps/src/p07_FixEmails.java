import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p07_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        Map<String, String> emailbook = new LinkedHashMap<>();

        while (!name.equals("stop")){
            String email = scanner.nextLine();
            String[] token = email.split("\\.");
            String domain = token[1];
            if (domain.equals("us") || domain.equals("uk") || domain.equals("com")){
                name= scanner.nextLine();
                continue;
            }
                emailbook.put(name, email);

            name= scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : emailbook.entrySet()) {
            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
        }

    }
}
