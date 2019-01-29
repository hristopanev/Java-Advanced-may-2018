import java.io.*;

public class p04_countCharacterTypes {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("input.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();
        PrintWriter writer = new PrintWriter("countCharactersTypes.txt");


        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        while (line != null) {


            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || line.charAt(i) == 'o'
                        || line.charAt(i) == 'u' && Character.isLowerCase(line.charAt(i))) {
                    vowels++;
                }else if (line.charAt(i) == '.' || line.charAt(i) == ',' || line.charAt(i) == '!' || line.charAt(i) == '?'){
                    punctuation++;
                }else if (Character.isLetter(line.charAt(i))){
                    consonants++;
                }
            }

         line = reader.readLine();
        }

        writer.println("Vowels: " + vowels);
        writer.println("Consonants: " + consonants);
        writer.println("Punctuation: " + punctuation);

        writer.close();
    }
}
