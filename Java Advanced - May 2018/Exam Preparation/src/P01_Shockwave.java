import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01_Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] coordinates = reader.readLine().split(" ");
        int n = Integer.parseInt(coordinates[0]);
        int m = Integer.parseInt(coordinates[1]);

        int[][] matrix = new int[n][m];


        String line;
        while (true) {
            if ("Here We Go".equals(line = reader.readLine())) {
                break;
            }

            int[] commandArgs = Arrays.stream(line.split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
            
            int x1 = commandArgs[0];
            int y1 = commandArgs[1];
            int x2 = commandArgs[2];
            int y2 = commandArgs[3];

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    try {
                        matrix[i][j]++;
                    }catch (Exception e){
                        System.out.println("Exception");
                    }
                }
            }
        }
        for (int[] r : matrix) {
            for (int c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
