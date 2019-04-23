import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String pattern = "[aoueiyAOUEIY]";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(text);

        int count = 0;

        while (matcher.find()){
            count++;
        }
        System.out.printf("Vowels: %d", count);



    }
}
