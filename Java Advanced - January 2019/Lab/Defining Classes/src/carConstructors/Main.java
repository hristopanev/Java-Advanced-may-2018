package carConstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < carCount; i++) {
            String[] carParts = scanner.nextLine().split("\\s+");
            Car car;

            if (carParts.length == 3){
                car = new Car(
                        carParts[0], carParts[1], Integer.parseInt(carParts[2]));

            } else {
                car = new Car(carParts[0]);
            }

            System.out.println(car.carInfo());
        }
    }
}
