import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p01_sortEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringNumber = scanner.nextLine().split(", ");

        List<Integer> evenNumbers = Arrays.stream(stringNumber)
                .map(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

        List<String> numbers =
                evenNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", numbers));

       evenNumbers.sort(Integer::compare);
       List<String> evenSorted = evenNumbers.stream()
               .map(String::valueOf)
               .collect(Collectors.toList());
        System.out.println(String.join(", ", evenSorted));

    }
}
