import java.util.Scanner;

public class p01 {
    public static void main(String[] args) {

        int[][] firstMatrix = readMatrix();
        int[][] secondMatrix = readMatrix();

        if (firstMatrix[0].length != secondMatrix[0].length ||
                firstMatrix.length != secondMatrix.length) {
            System.out.println("not equal");
            return;
        }


        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < secondMatrix[0].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    System.out.println("not equal");
                    return;
                }
            }
        }

        System.out.println("equal");
    }

    private static  int[][] readMatrix(){
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cows = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cows];

        for (int row = 0; row < rows; row++) {
            String[] colData = scanner.nextLine().split("\\s+");

            for (int col = 0; col < cows; col++) {
                matrix[row][col] = Integer.parseInt(colData[col]);
            }
        }

        return matrix;
    }
}
