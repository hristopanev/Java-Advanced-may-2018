import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputNames = scanner.nextLine().split("-");
        Map<String, String> phoneBook = new LinkedHashMap<>();

        while (!"search".equals(inputNames[0])){

            String name = inputNames[0];
            String phoneNumner = inputNames[1];

            if (!phoneBook.containsKey(inputNames[0])){
                phoneBook.put(name, phoneNumner);
            }
            phoneBook.put(name, phoneNumner);


           inputNames = scanner.nextLine().split("-");
            System.out.println();
        }
        String searchNames = scanner.nextLine();

        while (!"stop".equals(searchNames)){

            if (phoneBook.containsKey(searchNames)){
                System.out.printf("%s -> %s%n", searchNames, phoneBook.get(searchNames));
            }else {
                System.out.printf("Contact %s does not exist.%n", searchNames);
            }
            searchNames = scanner.nextLine();
        }


    }
}
