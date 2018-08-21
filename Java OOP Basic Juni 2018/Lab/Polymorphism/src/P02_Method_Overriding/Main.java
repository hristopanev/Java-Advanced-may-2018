package P02_Method_Overriding;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(5, 10);

        Rectangle square = new Square(10);

        System.out.println(rectangle.area());
        System.out.println(square.area());

    }
}
