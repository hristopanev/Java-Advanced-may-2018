import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p03_customMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        Function<ArrayList<Integer>, Integer> findMinNumber = (arr -> {
            return arr.stream().min(Integer::compareTo).get();
        });

        System.out.println(findMinNumber.apply((ArrayList<Integer>) numbers));
        //TODO
    }
}
