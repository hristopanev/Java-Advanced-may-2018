import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] s = reader.readLine().split("\\s+");

        int rows = Integer.parseInt(s[0]);
        int cols = Integer.parseInt(s[0]);

        String[][] field = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            field[i] = reader.readLine().split("");

        }


    }
}
