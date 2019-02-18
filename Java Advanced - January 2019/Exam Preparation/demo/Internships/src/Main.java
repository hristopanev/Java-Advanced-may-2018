import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int problemCount = Integer.parseInt(scanner.nextLine());
        int candidatesCount = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> problems = new ArrayDeque<>();
        ArrayDeque<String> candidates = new ArrayDeque<>();

        for (int i = 0; i < problemCount; i++) {
            String problemName = scanner.nextLine();
            problems.addFirst(problemName);
        }

        for (int i = 0; i < candidatesCount; i++) {
            String candidateName = scanner.nextLine();
            if (isValidName(candidateName)) {
                candidates.offer(candidateName);
            }
        }

        while (candidates.size() > 1 && problems.size() > 0){
            String currentCandidate = candidates.poll();
            String currentProblem = problems.poll();

            if (isProblemsSolved(currentCandidate, currentProblem)){
                System.out.printf("%s solved %s.%n", currentCandidate, currentProblem);
                candidates.offer(currentCandidate);
            }else {
                problems.offer(currentProblem);
                System.out.printf("%s failed %s.%n", currentCandidate, currentProblem);

            }
        }

        if (candidates.size() == 1){
            System.out.println(candidates.poll() + " gets the job!");
        }else {
            System.out.println(String.join(", ", candidates));
        }
    }

    private static boolean isProblemsSolved(String candidate, String problem) {
        int candidateSum = getStringSum(candidate);
        int problemSum = getStringSum(problem);

        return candidateSum > problemSum;
    }

    private static int getStringSum(String sting) {
        int sum = 0;

        for (int i = 0; i < sting.length(); i++) {
            sum += sting.charAt(i);
        }
        return  sum;
    }

    private static boolean isValidName(String name) {
        return name.matches("[A-Z][a-z]+ [A-Z][a-z]+");
    }
}
