import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputA = scanner.nextLine().split("\\s+");
        int Ax = Integer.parseInt(inputA[0]);
        int Ay = Integer.parseInt(inputA[1]);
        String[] inputB = scanner.nextLine().split("\\s+");
        int Bx = Integer.parseInt(inputB[0]);
        int By = Integer.parseInt(inputB[1]);
        String[] inputC = scanner.nextLine().split("\\s+");
        int Cx = Integer.parseInt(inputC[0]);
        int Cy = Integer.parseInt(inputC[1]);


        Ax = Ax * (By - Cy);
        Bx = Bx * (Cy - Ay);
        Cx = Cx * (Ay - By);
        int area = (Ax + Bx + Cx)/2;

        System.out.println(Math.abs(area));
    }
}
