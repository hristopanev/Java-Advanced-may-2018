import java.util.ArrayDeque;
import java.util.Scanner;

public class p03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> bits = new ArrayDeque<>();

        if (number == 0){
            System.out.println(0);
            return;
        }

        while (number != 0){
            int lefttover = number % 2;
            bits.push(lefttover);

            number = number / 2;
        }

        while (!bits.isEmpty()){
            System.out.print(bits.pop());
        }
    }
}
