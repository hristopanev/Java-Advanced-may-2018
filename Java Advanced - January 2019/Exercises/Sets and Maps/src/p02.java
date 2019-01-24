import java.util.*;

public class p02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] token = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstSize = token[0];
        int secondSize = token[1];

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        while (firstSize-- > 0){
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        while (secondSize-- > 0){
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

        firstSet.retainAll(secondSet);

        for (Integer integer : firstSet) {
            System.out.print(integer + " ");
        }

    }
}
