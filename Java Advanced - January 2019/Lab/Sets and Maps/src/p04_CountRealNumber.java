import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p04_CountRealNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> occurrences = new LinkedHashMap<>();

//        for (int i = 0; i < numbers.length; i++) {
//            if (occurrences.containsKey(numbers[i])){
//                occurrences.put(numbers[i], occurrences.get(numbers[i]) + 1);
//            }else {
//                occurrences.put(numbers[i], 1);
//            }
//        }


        for (double value : numbers) {
            if (!occurrences.containsKey(value)){
                occurrences.put(value, 1);
            }else {
                occurrences.put(value, occurrences.get(value) +1);
            }
        }

        for (Double aDouble : occurrences.keySet()) {
            System.out.printf("%.1f -> %d%n", aDouble, occurrences.get(aDouble));
        }
    }
}
