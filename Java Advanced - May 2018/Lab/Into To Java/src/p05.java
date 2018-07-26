import java.util.Scanner;

public class p05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double km = Double.parseDouble(scanner.nextLine());
        String dayTime = scanner.nextLine();
        double sum;

        if (km < 20){
            if ("night".equals(dayTime)){
                sum = 0.9;
            }else {
                sum = 0.79;
            }
            sum = sum * km + 0.7;
        }else  if (km < 100){
            sum = 0.09 * km;
        }else {
            sum = 0.06 * km;
        }
        System.out.printf("%.02f", sum);
    }
}
