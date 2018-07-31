import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lenght = scanner.nextLine().split("\\s+");

        int firstLenght = Integer.parseInt(lenght[0]);
        int secondLenght = Integer.parseInt(lenght[1]);

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        FillSet(scanner, firstLenght, firstSet);
        FillSet(scanner, secondLenght, secondSet);

        String result = "";

        for (String elements : firstSet) {

            if (secondSet.contains(elements)){
                result += elements + " ";
            }
        }
        System.out.println(result.trim());
    }

    private static void FillSet(Scanner scanner, int lenght, Set<String> set) {
        for (int i = 0; i < lenght; i++) {
            set.add(scanner.nextLine());
        }
    }


}
