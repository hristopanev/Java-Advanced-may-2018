import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class p01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> users = new LinkedHashSet<>();

        while (n-- > 0){
            String username = scanner.next();

            users.add(username);
        }

        users.forEach(System.out::println);
    }
}
