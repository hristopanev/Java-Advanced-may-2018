import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] firstInputNumbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondInputNumbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> theNumbers = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        fillNumbers(firstInputNumbers, theNumbers);
        fillNumbers(secondInputNumbers, queue);

        List<Integer> resultList = new ArrayList<>();
        while (resultList.size() != 6) {
            int firstNumber = theNumbers.pop();
            int secondNumber = queue.pop();

            if (secondNumber % firstNumber == 0) {
                resultList.add(secondNumber);
                continue;
            } else if (secondNumber % firstNumber != 0) {
                queue.addLast(secondNumber + 1);
                theNumbers.addFirst(firstNumber);
            }
        }

        List<String> result = new ArrayList<>();
        for (Integer integer : resultList) {
            result.add(integer.toString());
        }

        System.out.println(String.join(", ", result));


    }

    private static void fillNumbers(int[] inputNumbers, ArrayDeque<Integer> numbers) {
        for (int number : inputNumbers) {
            numbers.add(number);
        }
    }
}
