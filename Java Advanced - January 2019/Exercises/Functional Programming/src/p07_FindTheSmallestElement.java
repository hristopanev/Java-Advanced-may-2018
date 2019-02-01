import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        Function<ArrayList<Integer>, Integer> findIndexOfMin = arr ->
                arr.lastIndexOf(arr.stream().min(Integer::compareTo).get());


        System.out.println(findIndexOfMin.apply(numbers));
    }
}
