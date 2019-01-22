import java.util.Scanner;

public class p01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[size][size];

        if (pattern.equals("A")){
            fillMatrixWithFirstPattern(matrix);
        }else {
            fillMatrixWithSecondPattern(matrix);
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixWithSecondPattern(int[][] matrix) {

        int value = 1;
        for (int col = 0; col < matrix.length; col++) {

            if (col % 2 == 0){
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = value++;
                }
            }else
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = value++;
                }
        }
    }

    private static void fillMatrixWithFirstPattern(int[][] matrix) {

        int value = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = value++;
            }
        }
    }
}
