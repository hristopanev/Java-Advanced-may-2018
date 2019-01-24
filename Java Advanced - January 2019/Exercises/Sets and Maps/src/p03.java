import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class p03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();

        while (n-- > 0){

            String[] inputElements = scanner.nextLine().split("\\s+");

            for (int i = 0; i < inputElements.length; i++) {
                elements.add(inputElements[i]);
            }
        }

        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
