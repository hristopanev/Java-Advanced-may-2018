import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> children = new ArrayDeque<>();
        Collections.addAll(children, names);
        int round = 1;

        while (children.size() > 1) {

            for (int i = 0; i < n - 1; i++) {
                String currentChild = children.poll();
                children.offer(currentChild);
            }

            if (isPrime(round)) {

                String child = children.peek();
                System.out.println("Prime " + child);
            } else {
                String child = children.poll();
                System.out.println("Removed " + child);
            }

            round++;
        }
        String lastChild = children.poll();
        System.out.println("Last is " + lastChild);


    }


    private static boolean isPrime(int number) {

        if (number == 1){
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
