import java.math.BigDecimal;
import java.util.Scanner;

public class p03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double kg = scanner.nextDouble();

        BigDecimal marksRate =
                new BigDecimal(4210500000000.0);
        BigDecimal priceInLv = new BigDecimal(1.20 * kg);

        BigDecimal result = marksRate.multiply(priceInLv);

        System.out.printf("%.2f marks", result);
    }
}
