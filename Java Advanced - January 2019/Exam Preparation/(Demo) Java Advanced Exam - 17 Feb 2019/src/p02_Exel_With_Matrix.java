import java.util.Arrays;
import java.util.Scanner;

public class p02_Exel_With_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowCount = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[rowCount][];

        for (int i = 0; i < rowCount; i++) {
            matrix[i] = scanner.nextLine().split(", ");
        }

        String[] commandsArguments = scanner.nextLine().split("\\s+");

        if (commandsArguments[0].equalsIgnoreCase("hide")){
            hideColumnAndPrint(matrix, commandsArguments[1]);
        }else if (commandsArguments[0].equalsIgnoreCase("sort")){
            sortByColumnAndPrint(matrix,commandsArguments[1]);
        }else {
            filterByColumnAndPrint(matrix, commandsArguments[1], commandsArguments[2]);
        }
    }

    private static void filterByColumnAndPrint(String[][] matrix, String filterColumn, String columnValue) {
        int filterColumnIndex = getColumnIndexByName(matrix[0],filterColumn);

        System.out.println(String.join(" | ", matrix[0]));
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][filterColumnIndex].equals(columnValue)){
                System.out.println(String.join(" | ", matrix[i]));
            }
        }
    }

    private static void sortByColumnAndPrint(String[][] matrix, String sortColumnName) {
        int sortColumnIndex = getColumnIndexByName(matrix[0], sortColumnName);

        for (int j = 0; j < matrix.length; j++) {
            for (int i = 1; i < matrix.length - 1 - j; i++) {
                if (matrix[i][sortColumnIndex].compareTo(matrix[i + 1][sortColumnIndex]) > 0){
                    String[] temp = matrix[i];
                    matrix[i] = matrix[i + 1];
                    matrix[i + 1] = temp;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (j != matrix[i].length -1){
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }

    }

    private static void hideColumnAndPrint(String[][] matrix, String hiddenColumn) {

        int hiddenColumnIndex = getColumnIndexByName(matrix[0], hiddenColumn);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == hiddenColumnIndex){
                    continue;
                }
                System.out.print(matrix[i][j]);
                if (j != matrix[i].length -1){
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }

    private static int getColumnIndexByName(String[] matrix, String ColumnName) {
        int hiddenColumnIndex = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].equals(ColumnName)){
                hiddenColumnIndex = i;
                break;
            }
        }
        return hiddenColumnIndex;
    }
}
