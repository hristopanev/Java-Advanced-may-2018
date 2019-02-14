import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class p02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stones = new ArrayDeque<>();
        int[] data = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int stone : data) {
            stones.addLast(stone);
        }
        int gold = 0;

        String line = reader.readLine();

        while (true) {

            String[] commandArgs = line.split("\\s+");

            switch (commandArgs[0]){
                case "Apply":
                    int acid = Integer.parseInt(commandArgs[2]);
                    while (acid-- > 0 && !stones.isEmpty()){
                        int element = stones.pop();
                        if (--element <= 0){
                            gold++;
                        }else {
                            stones.addLast(element);
                        }
                    }
                    break;
                case "Air":
                    int label = Integer.parseInt(commandArgs[2]);
                    if (gold <= 0){
                        break;
                    }
                    gold--;
                    stones.addLast(label);
                    break;
                    default:
                        while (!stones.isEmpty()){
                            System.out.print(stones.pop() + " ");
                        }
                        System.out.println("\n" +gold);
                        return;
            }

            line = reader.readLine();
        }
    }
}
