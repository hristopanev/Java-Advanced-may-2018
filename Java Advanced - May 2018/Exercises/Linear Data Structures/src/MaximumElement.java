import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (numberOfCommands != 0){
            numberOfCommands--;

            String[] tokens = scanner.nextLine().split("\\s+");

            if (tokens.length == 2){
                stack.push(Integer.parseInt(tokens[1]));
            }else {
                if ("2".equals(tokens[0])){
                    stack.pop();
                }else {
                    System.out.println(Collections.max(stack));
                }
            }

        }
    }
}
