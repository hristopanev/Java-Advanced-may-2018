import java.util.HashSet;
import java.util.Scanner;

public class ParkingLos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<String> cars = new HashSet<>();

        String line = scanner.nextLine();

        while (!"END".equals(line)){
            String[] tokens = line.split(", ");
            String directions = tokens[0];
            String carPlate = tokens[1];

            if ("IN".equals(directions)){
                cars.add(carPlate);
            }else {
                cars.remove(carPlate);
            }

            line = scanner.nextLine();
        }

        if (cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            for (String car : cars) {
                System.out.println(car);
            }
        }

    }
}
