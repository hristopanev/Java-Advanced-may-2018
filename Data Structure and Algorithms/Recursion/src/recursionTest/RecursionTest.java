package recursionTest;

public class RecursionTest {

    public void recursion(int number) {
        if (number >= 1) {
            recursion(number -1);
            System.out.println("Number: " + number);
        }
    }
}
