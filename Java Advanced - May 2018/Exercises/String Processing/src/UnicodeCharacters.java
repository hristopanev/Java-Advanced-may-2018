import java.util.List;
import java.util.Scanner;

public class UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();

        for (char c : input) {
            System.out.printf("\\u00%s", Integer.toHexString(c));
        }
    }
}
