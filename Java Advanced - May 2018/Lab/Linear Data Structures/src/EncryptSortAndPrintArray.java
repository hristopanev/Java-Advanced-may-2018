import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int namesCount = Integer.parseInt(scanner.nextLine());

        String[] names = new String[namesCount];

        for (int i = 0; i < names.length; i++) {
            names[i] = scanner.nextLine();
        }

        int[] encryptedNames = new  int[namesCount];
        for (int j  = 0; j < names.length; j++) {
            String name = names[j];
            int currentNameSum = 0;

            for (int i = 0; i < name.length(); i++) {
                char currentLetter = name.charAt(i);

                if (CheckLetterIsVowel(currentLetter)){
                    currentNameSum += currentLetter *name.length();
                }else {
                    currentNameSum += currentLetter / name.length();
                }
            }
            encryptedNames[j] = currentNameSum;
        }
        Arrays.sort(encryptedNames);
        PrintResult(encryptedNames);
    }


    public static boolean CheckLetterIsVowel(char letter){
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (char vowel : vowels) {
            if (vowel == Character.toLowerCase(letter)){
                return true;
            }
        }
        return false;
    }
    public static void PrintResult (int[] values){
        for (int value : values) {
            System.out.println(value);
        }
    }
}
