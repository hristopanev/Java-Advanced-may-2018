import java.util.Scanner;

public class p01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cows = Integer.parseInt(input[1]);

        int[][] firstMatrix = new int[rows][cows];

        for (int row = 0; row < rows; row++) {
            String[] colData = scanner.nextLine().split("\\s+");

            for (int col = 0; col < cows; col++) {
                firstMatrix[row][col] = Integer.parseInt(colData[col]);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cows; col++) {
                System.out.println(firstMatrix[row][col]);
            }
        }
    }
}
