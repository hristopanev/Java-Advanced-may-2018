import java.io.*;

public class p02_sumBytes {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("input.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();

        FileWriter writer = new FileWriter("totalSum.txt");

        int totalSum = 0;

        while (line != null) {

            int sum = 0;

            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }

            totalSum += sum;
            line = reader.readLine();

        }

        writer.write(totalSum + System.lineSeparator());
        writer.close();
    }
}
