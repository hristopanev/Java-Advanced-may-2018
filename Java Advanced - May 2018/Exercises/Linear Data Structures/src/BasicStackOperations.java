import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firsLine = scanner.nextLine().split("\\s+");

        int elementToPush = Integer.parseInt(firsLine[0]);
        int elementToPop = Integer.parseInt(firsLine[1]);
        int searchedElements = Integer.parseInt(firsLine[2]);

        String[] secondLine = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <elementToPush; i++) {
            stack.push(Integer.parseInt(secondLine[i]));
        }

        for (int i = 0; i < elementToPop; i++) {
            if (stack.isEmpty()){
                break;
            }
            stack.pop();
        }
        if (stack.isEmpty()){
            System.out.println(0);
        }else  if (stack.contains(searchedElements)){
            System.out.println(true);
        }else {
            System.out.println(Collections.min(stack));
        }
    }
}
