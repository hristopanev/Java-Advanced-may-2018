import java.util.Scanner;

public class p08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        for (int i = 1; i <= 8; i++) {
            for (int j = 1 + i; j <= 9; j++) {
                for (int k = 1 + j; k <= 10; k++) {
                    System.out.printf("%d %d %d%n", i, j, k);
                }
            }
        }
    }
}
