import java.io.*;

public class p01_sumLines {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("input.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();

        FileWriter writer = new FileWriter("Sum Lines.txt");

        while (line != null) {

            int sum = 0;

            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }

            writer.write(sum + System.lineSeparator());
            line = reader.readLine();

        }

        writer.close();
    }
}
