import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class p05_reverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>> reversedAndExclude = ((arr, num) -> {
            Collections.reverse(arr);

          return   arr
                    .stream()
                    .filter(e -> e % num != 0)
                    .collect(Collectors.toCollection(ArrayList::new));
        });

        Consumer<ArrayList<Integer>> printer = e -> e.forEach(v -> System.out.print(v +" "));

        printer.accept(reversedAndExclude.apply((ArrayList<Integer>) numbers, n));
    }
}
