import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rotateData = scanner.nextLine().split("[()]+");

        int rorateAngle = Integer.parseInt(rotateData[1]) % 360;

        ArrayList<String> inputString = new ArrayList<>();
        String line = scanner.nextLine();
        int maxLenght = line.length();

        while (!line.equals("END")){
            inputString.add(line);



            line = scanner.nextLine();
            if (maxLenght < line.length()){
                maxLenght = line.length();
            }
        }

        char[][] matrix = new char[inputString.size()][maxLenght];

        for (int r = 0; r < inputString.size(); r++) {
            for (int c = 0; c < maxLenght; c++) {
                if (c > inputString.get(r).length() - 1){
                    matrix[r][c] = ' ';
                }else {
                    matrix[r][c] = inputString.get(r).charAt(c);
                }
            }
        }

        if (rorateAngle == 90){

            for (int c = 0; c < maxLenght; c++) {
                for (int r = matrix.length - 1; r >= 0 ; r--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }else if (rorateAngle == 180){
            for (int r = matrix.length - 1; r >= 0 ; r--) {
                for (int c = maxLenght - 1 ;  c >= 0; c--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }else if (rorateAngle == 270){
            for (int c = maxLenght - 1; c >= 0 ; c--) {
                for (int r = 0 ;  r < matrix.length; r++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }else {
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < maxLenght; c++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }
    }
}
