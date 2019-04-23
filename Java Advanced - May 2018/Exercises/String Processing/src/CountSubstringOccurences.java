import java.util.ArrayList;
import java.util.Scanner;

public class CountSubstringOccurences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();
        String command = scanner.nextLine().toLowerCase();

        int count = 0;

        for (int i = 0; i < input.length() - command.length(); i++) {
            if (input.substring(i, command.length() + i).equals(command)){
                count++;
            }
        }
        System.out.println(count);



    }
}
