import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class p03_Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();

        fillNumbers(scanner, firstPlayer, secondPlayer);

        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()){
                System.out.println(firstPlayer
                        .isEmpty() ? "Second player win" : "First player win");
                return;
            }


            int firstNum = firstPlayer.iterator().next();
            firstPlayer.remove(firstNum);
            int secondNum = secondPlayer.iterator().next();
            secondPlayer.remove(secondNum);

            if (firstNum > secondNum){
                firstPlayer.add(firstNum);
                firstPlayer.add(secondNum);
            }else {
                secondPlayer.add(firstNum);
                secondPlayer.add(secondNum);
            }
        }

        PrintResult(firstPlayer, secondPlayer);



    }

    private static void PrintResult(Set<Integer> firstPlayer, Set<Integer> secondPlayer) {

        if (firstPlayer.size() > secondPlayer.size()){
            System.out.println("First player win!");
        }else if (firstPlayer.size() < secondPlayer.size()){
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw!");
        }
    }

    private static void fillNumbers(Scanner scanner, Set<Integer> firstPlayer, Set<Integer> secondPlayer) {

        String[] firstPlayerNumber = scanner.nextLine().split("\\s+");
        String[] secondPlayerNumber = scanner.nextLine().split("\\s+");

        for (String player : firstPlayerNumber) {
            firstPlayer.add(Integer.parseInt(player));
        }

        for (String player : secondPlayerNumber) {
            secondPlayer.add(Integer.parseInt(player));
        }
    }
}
