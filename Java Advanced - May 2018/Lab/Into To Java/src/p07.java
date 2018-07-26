import java.math.BigInteger;
import java.util.Scanner;

public class p07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int temp = n;

        BigInteger result = BigInteger.ONE;

        do {
            result = result.multiply(BigInteger.valueOf(n));
            n++;
        }while (n <=  m);
        System.out.printf("product[%d..%d] = %s", temp, m, result);
    }
}
