import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p05_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> lexicon  = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {

            char alpha = text.charAt(i);

            if (!lexicon.containsKey(alpha)){
                lexicon.put(alpha, 1);
            }else {
                lexicon.put(alpha, lexicon.get(alpha) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : lexicon.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " " + "time/s");
        }

    }
}
