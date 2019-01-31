
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class p05_filterByAge {
    public static void main(String[] args) {

        BiPredicate<Map.Entry<String, Integer>, Integer> youngThan =
                (person, ageLimit) -> person.getValue() < ageLimit;

        BiPredicate<Map.Entry<String, Integer>, Integer> olderThan =
                (person, ageLimit) -> person.getValue() >= ageLimit;

        Consumer<Map.Entry<String, Integer>> printName =
                person -> System.out.println(person.getKey());

        Consumer<Map.Entry<String, Integer>> printAge =
                person -> System.out.println(person.getValue());

        Consumer<Map.Entry<String, Integer>> printNameAndAge =
                person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        int peopleCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < peopleCount; i++) {
            String[] personDate = scanner.nextLine().split(", ");

            people.put(personDate[0], Integer.parseInt(personDate[1]));
        }

        String comparison = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String printType = scanner.nextLine();


        people.entrySet().stream()
                .filter(person -> comparison.equals("younger") ?
                        youngThan.test(person, ageLimit) :
                        olderThan.test(person, ageLimit)
                )
                .forEach(person -> {
                    switch (printType) {
                        case "age":
                            printAge.accept(person);
                            break;
                        case "name":
                            printName.accept(person);
                            break;
                        default:
                            printNameAndAge.accept(person);
                            break;
                    }
                });
    }
}
