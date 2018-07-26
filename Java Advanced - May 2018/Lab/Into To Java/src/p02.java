import java.util.Scanner;

public class p02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = scanner.nextDouble();
        double secondNum = scanner.nextDouble();
        double thirdNum = scanner.nextDouble();

        double sum = firstNum + secondNum + thirdNum;
        double avarage = sum / 3;

        System.out.printf("%.2f", avarage);
    }

}
