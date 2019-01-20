import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class p04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int elementToAdd = tokens[0];
        int elementToRemove = tokens[1];
        int elementToFind = tokens[2];

        Deque<Integer> queue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(elementToAdd)
                .forEach(queue::offer);


        while (elementToRemove-- > 0) {
            queue.remove();


        }

        if (queue.contains(elementToFind)) {
            System.out.println("true");
        } else {
            int minNumber = Integer.MAX_VALUE;

            if (queue.isEmpty()) {
                minNumber = 0;
            }
            while (!queue.isEmpty()) {
                int current = queue.remove();

                if (current < minNumber) {
                    minNumber = current;
                }
            }
            System.out.println(minNumber);
        }
    }
}
