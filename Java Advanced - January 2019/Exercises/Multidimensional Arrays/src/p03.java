import java.util.Arrays;
import java.util.Scanner;

public class p03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int firstDiagonal = calculatorFirstDiagonal(matrix);
        int secondDiagonal = calculatorSecondDiagonal(matrix);

        System.out.println(Math.abs(firstDiagonal - secondDiagonal));

    }

    private static int calculatorSecondDiagonal(int[][] matrix) {

        int sum = 0;
        int row = matrix.length - 1, col = 0;

        while (row >= 0){
            sum += matrix[row--][col++];
        }

        return sum;
    }

    private static int calculatorFirstDiagonal(int[][] matrix) {

        int sum = 0;
        int row = 0, col = 0;

        while (row < matrix.length) {
            sum += matrix[row++][col++];
        }

        return sum;
    }
}
