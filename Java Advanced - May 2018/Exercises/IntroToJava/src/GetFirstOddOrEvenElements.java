import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetFirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String[] inputCommands = scanner.nextLine().split(" ");

        int tokens = Integer.parseInt(inputCommands[1]);
        int counter = 0;
        int number;
        if ("odd".equals(inputCommands[2])){
            for (int i = 0; i < input.length; i++) {
                number = Integer.parseInt(input[i]);
                if (number % 2 == 1){
                    System.out.print(number + " ");
                    counter++;
                    if (tokens <= counter){
                        break;
                    }
                }
            }
        }else{
            for (int i = 0; i <input.length; i++) {
                number = Integer.parseInt(input[i]);
                if (number % 2 == 0){
                    System.out.print(number + " ");
                    counter++;
                    if (tokens <= counter){
                        break;
                    }
                }
            }
        }
    }
}
