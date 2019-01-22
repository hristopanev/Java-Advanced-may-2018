import java.util.Scanner;

public class p03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] first = new char[rows][cols];
        char[][] second = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                first[row][col] = line[col].charAt(0);
            }
        }

        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                second[row][col] = line[col].charAt(0);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (first[row][col] == second[row][col]){
                    System.out.print(first[row][col]);
                }else {
                    System.out.print("*");
                }

                if (col != cols - 1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
