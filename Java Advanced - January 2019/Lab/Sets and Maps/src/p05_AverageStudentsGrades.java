import java.text.DecimalFormat;
import java.util.*;

public class p05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputLine = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < inputLine; i++) {
            String[] parts = scanner.nextLine().split("\\s+");

            String name = parts[0];
            double grade = Double.parseDouble(parts[1]);

            List<Double> currentGrades = new ArrayList<>();

            if (students.containsKey(name)) {
                currentGrades = students.get(name);
            }
            currentGrades.add(grade);
            students.put(name, currentGrades);

        }

        for (String studentName : students.keySet()) {

            System.out.print(studentName + " -> ");
            double gradeSum = 0;

            List<Double> studentGrades = students.get(studentName);
            for (Double grade : studentGrades) {
                gradeSum += grade;
                System.out.printf("%.2f ", grade);
            }

            gradeSum = Math.round(gradeSum * 100) / 100.0;

            System.out.printf("(avg: %.2f)%n", Math.round((gradeSum / studentGrades.size()) * 100) / 100.0);
        }

    }
}
