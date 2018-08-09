import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class P02_LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stones = new ArrayDeque<>();
        int[] s = Arrays.stream(reader.readLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

        for (int i : s) {
            stones.addLast(i);
        }
        int gold = 0;

        String line = reader.readLine();
        while (true) {
            String[] comands = line.split(" ");

            switch (comands[0]){
                case "Apply":
                    gold = ApplyAcid(stones, gold, comands[2]);
                    break;
                case "Air":
                    gold = AirLeak(stones, gold, comands[2]);
                    break;
                    default:
                        PrintResult(stones, gold);
                        return;
            }

            line = reader.readLine();
        }
    }

    private static int AirLeak(ArrayDeque<Integer> stones, int gold, String comand) {
        int label = Integer.parseInt(comand);
        if (gold <= 0){
            return gold;
        }
        gold--;
        stones.addLast(label);
        return gold;
    }

    private static int ApplyAcid(ArrayDeque<Integer> stones, int gold, String comand) {
        int acid = Integer.parseInt(comand);
        while (acid--> 0 && !stones.isEmpty()){
            int element = stones.pop();
            if (--element <= 0){
                gold++;
            }else {
                stones.addLast(element);
            }
        }
        return gold;
    }

    private static void PrintResult(ArrayDeque<Integer> stones, int gold) {
        while (!stones.isEmpty()){
            System.out.print(stones.pop() + " ");
        }
        System.out.println("\n" + gold);
    }
}
