import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
        int sum = 0;
        for (int[] row : matrix) {
            for (int col : row) {
                sum+= col;
            }

        }

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);
    }
}
