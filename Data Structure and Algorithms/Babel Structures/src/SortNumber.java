import java.util.Arrays;

public class SortNumber {
    public static void main(String[] args) {

        int[] numbers = {3, 5, 0, -10, 400, 1, 40, 33, -1, 3040, 12};

        BubbleSort bubbleSort = new BubbleSort();
        numbers = bubbleSort.sortNumber(numbers);

        Arrays.stream(numbers).forEach(System.out::println);
    }
}
