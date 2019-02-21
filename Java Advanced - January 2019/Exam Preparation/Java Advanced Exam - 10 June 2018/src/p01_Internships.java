import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p01_Internships {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int problemsCount = Integer.parseInt(reader.readLine());
        int candidatesCount = Integer.parseInt(reader.readLine());

        ArrayDeque<String> problems = new ArrayDeque<>();
        ArrayDeque<String> candidates = new ArrayDeque<>();

        fillItems(reader, problemsCount, problems);
        fillItems(reader, candidatesCount, candidates);

        while (true){
            if (candidates.size() == 1 || problems.isEmpty()){
                break;
            }

            String problem = problems.pollLast();
            String candidate = candidates.pop();
            if (!isValidName(candidate)){
                problems.addLast(problem);
                continue;
            }
            int charSumProblem = 0;
            int charSumCandidate = 0;

            charSumProblem = sumChars(problem, charSumProblem);

            charSumCandidate = sumChars(candidate, charSumCandidate);


            if (charSumCandidate > charSumProblem){
                candidates.add(candidate);
                System.out.printf("%s solved %s.%n", candidate, problem);
            }else {
                problems.addFirst(problem);
                System.out.printf("%s failed %s.%n", candidate, problem);
            }
        }

        if (candidates.size() == 1){
            for (String candidate : candidates) {
                System.out.printf("%s gets the job!", candidate);
            }
        }else if (candidates.size() == 0){
            return;
        }else {
            System.out.println(String.join(", ", candidates));

        }
//
//        if (!name.matches("[A-Z][a-z]+ [A-Z][a-z]")){
//            return false;
//        }
//        return true;

    }

    private static boolean isValidName(String name){
        String[] validName = name.split("\\s+");


        if (validName.length < 2){
            return false;
        }
        String firstName = validName[0];
        String lastName = validName[1];

        if (isValid(firstName)) return false;
        if (isValid(lastName)) return false;

        return true;
    }

    private static boolean isValid(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isUpperCase(name.charAt(0))) {
                return true;
            } else if (i > 1 && !Character.isLowerCase(name.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static int sumChars(String pr, int charSum) {
        for (int i = 0; i < pr.length(); i++) {
            charSum += pr.toCharArray()[i];
        }
        return charSum;
    }


    private static void fillItems(BufferedReader reader, int count, ArrayDeque<String> stack) throws IOException {
        for (int i = 0; i < count; i++) {
            String line = reader.readLine();
            stack.add(line);
        }
    }
}
