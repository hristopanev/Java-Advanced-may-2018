import java.io.*;

public class p05_lineNumber {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("inputLineNumbers.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();

        PrintWriter writer = new PrintWriter("lineNumber.txt");
        int lineCount = 0;

        while (line != null) {
            lineCount++;

            writer.println(lineCount + ". " + line);
            line = reader.readLine();
        }

        writer.close();
    }
}
