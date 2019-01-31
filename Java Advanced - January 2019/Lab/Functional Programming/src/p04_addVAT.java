import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class p04_addVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] prices = scanner.nextLine().split(", ");

        UnaryOperator<Double> addVat = v -> v * 1.2;

        System.out.println("Prices with VAT:");
        Arrays.stream(prices)
                .map(Double::parseDouble)
                .map(addVat)
                .forEach(p -> System.out.printf("%.2f%n", p));
    }
}
