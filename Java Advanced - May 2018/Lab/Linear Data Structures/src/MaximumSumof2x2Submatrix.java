import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaximumSumof2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = FillMatrix(scanner);

        int bestSum = Integer.MIN_VALUE;

        int rowIndex = 0;
        int colIndex = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (sum > bestSum){
                    bestSum = sum;
                    rowIndex = row;
                    colIndex = col;
                }
            }
        }
        for (int i = rowIndex; i < rowIndex + 2; i++) {
            for (int j = colIndex; j < colIndex + 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(bestSum);
    }

    private static int[][] FillMatrix(Scanner scanner) {
        List<String> dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        int rows = Integer.parseInt(dimensions.get(0));
        int cows = Integer.parseInt(dimensions.get(1));

        int[][] matrix = new int[rows][cows];

        for (int row = 0; row < matrix.length; row++) {
            String[] values = scanner.nextLine().split(", ");

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(values[col]);
            }
        }
        return matrix;
    }
}
