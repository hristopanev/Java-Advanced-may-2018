package carInfo;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carCount = Integer.parseInt(scanner.nextLine());

        IntStream
                .rangeClosed(1, carCount)
                .boxed()
                .map(n -> scanner.nextLine().split("\\s+"))
                .map(data -> {
                    Car current = new Car();
                    current.setMake(data[0]);
                    current.setModel(data[1]);
                    current.setHorsePower(Integer.parseInt(data[2]));

                    return current;
                })
                .forEach(car -> System.out.println(car.getInfo()));


//        for (int i = 0; i < carCount; i++) {
//            String[] carParts = scanner.nextLine().split("\\s+");
//            Car current = new Car();
//            current.setMake(carParts[0]);
//            current.setModel(carParts[1]);
//            current.setHorsePower(Integer.parseInt(carParts[2]));
//
//            System.out.print(current.getInfo());
//        }

    }
}
