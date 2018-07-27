import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] parentheses = scanner.nextLine().split("");

        if (parentheses.length % 2 == 1 || parentheses.length >= 1000){
            System.out.print("NO");
        }else {
            ArrayDeque<String> deque = new ArrayDeque<>();
            Collections.addAll(deque, parentheses);

            while (!deque.isEmpty()) {

                String first = deque.removeFirst();
                String second = deque.removeLast();

                if (!IsValidParentheses((first + second))) {
                    System.out.print("N0");
                    return;
                }
            }

            System.out.print("YES");
        }
    }

    private static boolean IsValidParentheses(String parentheses) {
        return "{}".equals(parentheses) || "()".equals(parentheses) || "[]".equals(parentheses);
    }
}
