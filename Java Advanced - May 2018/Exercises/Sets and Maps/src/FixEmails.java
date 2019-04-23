import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> mailBook = new LinkedHashMap<>();

        while (true){
            String name = scanner.nextLine();
            if ("stop".equals(name)){
                break;
            }
            String mails = scanner.nextLine();
            String[] chekDomain = mails.split("\\.");

            if ("bg".equals(chekDomain[1])){
                if (!mailBook.containsKey(name)){
                    mailBook.put(name, mails);
                }
            }
        }

        for (Map.Entry<String, String> entry : mailBook.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
