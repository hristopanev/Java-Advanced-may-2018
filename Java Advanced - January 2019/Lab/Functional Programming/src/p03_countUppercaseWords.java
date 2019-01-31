import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p03_countUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Predicate<String> isStartingWithCapital = x -> Character.isAlphabetic(x.charAt(0)) ?
                Character.isUpperCase(x.charAt(0)) :
                Character.isUpperCase(x.charAt(1));

        List<String> capitalWords = Arrays.stream(words)
                .filter(isStartingWithCapital)
                .collect(Collectors.toList());

        System.out.println(capitalWords.size());
        capitalWords.forEach(System.out::println);
    }
}
