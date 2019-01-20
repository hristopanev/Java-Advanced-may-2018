import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class p02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int elementsToPush = tokens[0];
        int elementsToPop = tokens[1];
        int elementToFind = tokens[2];

        Deque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(elementsToPush)
                .forEach(stack::push);

        while (elementsToPop-- > 0){
            stack.pop();
        }

        if (stack.contains(elementToFind)){
            System.out.println("true");
        }else {
            int minNum = Integer.MAX_VALUE;

            if (stack.isEmpty()){
                minNum = 0;
            }
            while (!stack.isEmpty()){
                int current = stack.pop();
                if (current< minNum){
                    minNum = current;
                }
            }

            System.out.println(minNum);
        }
    }
}
