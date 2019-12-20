import java.util.Arrays;

public class SortString {
    public static void main(String[] args) {
        String[] names = {"John", "Don", "Peter", "Ivan", "Alex", "Jon", "Vladimir"};

        BubbleSort bubbleSort = new BubbleSort();
        names = bubbleSort.sortString(names);

        Arrays.stream(names).forEach(System.out::println);
    }
}
