package p03.Ferrari;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalClassFormatException {
        Scanner scanner = new Scanner(System.in);

        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();


        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }

        var driver = scanner.nextLine();

        var ferrari =  new Ferrari(driver);

        System.out.println(ferrari);
    }
}
