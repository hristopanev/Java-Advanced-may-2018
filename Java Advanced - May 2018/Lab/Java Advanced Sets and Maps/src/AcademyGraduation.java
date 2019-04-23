import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scanner.nextLine());

        Map<String, double[]> students = new TreeMap<>();

        while(studentsCount -- > 0){
            String studentName = scanner.nextLine();
            double[] studentGrades = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble).toArray();

            students.put(studentName, studentGrades);
        }

        for (Map.Entry<String, double[]> entry : students.entrySet()) {
            double avg = 0;
            for (double s : entry.getValue()) {
                avg += s;
            }
            avg /= entry.getValue().length;
            System.out.printf("%s is graduated with %s%n",
                    entry.getKey(), avg);
        }
    }
}
