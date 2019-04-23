import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String inputLine = scanner.nextLine();
        String[] format = inputLine.split("\\s+");

        String hexNumber = Integer.toHexString(Integer.parseInt(format[0])).toUpperCase();
        String binary = Integer.toBinaryString(Integer.parseInt(format[0]));
        double inputNumberB = Double.parseDouble(format[1]);
        double inputNumberC = Double.parseDouble(format[2]);
        int firstSpace = 10 - hexNumber.length();
        int secondSpace = 10 - format[1].length();

        int thirdSpace = 10 - format[2].length();

        System.out.printf("|%s", hexNumber);
        for (int i = 0; i < firstSpace; i++) {
            System.out.print(" ");

        }
        System.out.printf("|%s|", binary);
        for (int i = 0; i < secondSpace; i++) {
            System.out.print(" ");
        }
        System.out.printf("%.2f|%.3f", inputNumberB, inputNumberC);
        for (int i = 0; i < thirdSpace; i++) {
            System.out.print(" ");
        }
        System.out.println("|");

    }
}


