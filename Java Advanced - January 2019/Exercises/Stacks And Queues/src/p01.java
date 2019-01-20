import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();
                Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .forEach(e -> stack.push(e));


//        Deque<Integer> stack = new ArrayDeque<>();
//        String[] numbersAsString = scanner.nextLine().split("\\s+");
//        for (int i = 0; i < numbersAsString.length; i++) {
//            stack.push(Integer.parseInt(numbersAsString[i]));
//        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
