import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class p01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> cars = new HashSet<>();
        String line = scanner.nextLine();

        while (!line.equals("END")) {
            String[] parts = line.split(", ");

            if (parts[0].equals("IN")) {
                cars.add(parts[1]);
            } else {
                cars.remove(parts[1]);
            }

            line = scanner.nextLine();
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }
        }

    }
}
