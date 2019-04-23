import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputLine = Integer.parseInt(scanner.nextLine());

        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < inputLine; i++) {
            String[] inputElements = scanner.nextLine().split(" ");

            elements.addAll(Arrays.asList(inputElements));
        }

        for (String element : elements) {
            System.out.print(element + " ");
        }

        //System.out.println((elements + "").replaceAll("[\\[\\]]", ""));

    }
}
