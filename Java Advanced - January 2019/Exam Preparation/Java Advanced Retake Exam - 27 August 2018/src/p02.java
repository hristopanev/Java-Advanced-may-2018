import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int matrixSize = Integer.parseInt(reader.readLine());
        String[] commands = reader.readLine().split(",");

        char[][] matrix = new char[matrixSize][matrixSize];

        int bombCount = 0;
        int sapperRow = 0;
        int sapperCol = 0;

        for (int i = 0; i < matrixSize; i++) {
            matrix[i] = reader.readLine().replace(" ", "").toCharArray();

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B'){
                    bombCount++;
                }else if (matrix[i][j] == 's'){
                    sapperRow = i;
                    sapperCol = j;
                }
            }
        }

        for (int i = 0; i < commands.length; i++) {


            if ("up".equalsIgnoreCase(commands[i])){
                if (sapperRow > 0){
                    sapperRow --;
                }
            }else if ("down".equalsIgnoreCase(commands[i])){
                if (sapperRow < matrixSize - 1){
                    sapperRow++;
                }
            }else if ("left".equalsIgnoreCase(commands[i])){
                if (sapperCol > 0){
                    sapperCol--;
                }
            }else if ("right".equalsIgnoreCase(commands[i])){
                if (sapperCol < matrixSize -1){
                    sapperCol++;
                }
            }

            if (matrix[sapperRow][sapperCol] == 'B'){
                bombCount--;
                System.out.println("You found a bomb!");
            }else if (matrix[sapperRow][sapperCol] == 'e'){
                System.out.println("END " + bombCount + " bombs left on the field");
                return;
            }

            if (bombCount == 0){
                System.out.println("Congratulations! You found all bombs!");
                return;
            }
        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",
                bombCount, sapperRow, sapperCol);
    }
}
