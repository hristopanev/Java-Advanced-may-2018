import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        ArrayDeque<List<Integer>> allNumbers = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            allNumbers.addLast(
                    Arrays.stream(reader.readLine().split("\\s+"))
                            .mapToInt(Integer::parseInt)
                            .boxed()
                            .collect(Collectors.toList()));
        }

        while (!allNumbers.isEmpty()){
            List<Integer> currentNumbers = allNumbers.pop();
            List<Integer> result = new ArrayList<>();
            int wave = currentNumbers.get(0);

            for (int i = 1; i < currentNumbers.size(); i++) {
                if (wave < currentNumbers.get(i)){
                    allNumbers.addLast(currentNumbers.subList(i, currentNumbers.size()));

                    break;
                }
            }
            output.add(wave);
        }
        System.out.println(output.size());
        System.out.println(Arrays.toString(output.toArray()).replaceAll("[\\]\\[,]", ""));
    }
}
