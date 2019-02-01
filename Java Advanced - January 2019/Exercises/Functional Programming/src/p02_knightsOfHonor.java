import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class p02_knightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> printer = s -> System.out.printf("Sir %s%n", s);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(printer);
    }
}
