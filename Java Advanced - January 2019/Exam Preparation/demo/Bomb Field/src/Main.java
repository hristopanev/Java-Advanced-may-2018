import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int fieldSize = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] field = new char[fieldSize][fieldSize];

        int bombCount = 0;
        int sapperRow =0;
        int sapperCol = 0;

        for (int i = 0; i < fieldSize; i++) {
            field[i] = scanner.nextLine().replace(" ", "").toCharArray();

            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'B'){
                    bombCount++;
                }else if (field[i][j] == 's'){
                    sapperRow = i;
                    sapperCol = j;
                }
            }
        }

        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];

            switch (currentCommand){
                case "up":
                    if (sapperRow > 0){
                        sapperRow --;
                    }
                    break;
                case "down":
                    if (sapperRow < fieldSize -1){
                        sapperRow++;
                    }
                    break;
                case "left":
                    if (sapperCol > 0){
                        sapperCol--;
                    }
                    break;
                case "right":
                    if (sapperCol < fieldSize -1){
                        sapperCol++;
                    }
                    break;
            }

            if (field[sapperRow][sapperCol] == 'B'){
                bombCount--;
                System.out.println("You found a bomb!");
                field[sapperRow][sapperCol] = '+';
            }else if (field[sapperRow][sapperCol] == 'e'){
                System.out.printf("END! %d bombs left on the field%n", bombCount);
                return;
            }

            if (bombCount == 0){
                System.out.println("Congratulations! You found all bombs!");
                return;
            }
        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", bombCount, sapperRow, sapperCol);
    }
}
