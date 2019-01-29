import java.io.*;

public class p03_allCapitals {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("input.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();

        FileWriter writer = new FileWriter("allCapitals.txt");

        String newLine = null;

        while (line != null){

            for (int i = 0; i < line.length(); i++) {
                writer.write(line.toUpperCase().charAt(i));
            }

            writer.write(System.lineSeparator());
            line = reader.readLine();
        }
        writer.close();
    }
}
