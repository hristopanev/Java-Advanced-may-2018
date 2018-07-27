import javafx.print.Collation;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class ReverseNumberswithaStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            stack.push(Integer.parseInt(numbers[i]));
        }
        for (Integer integer : stack) {
            System.out.print(stack.poll() + " ");
        }



    }
}
