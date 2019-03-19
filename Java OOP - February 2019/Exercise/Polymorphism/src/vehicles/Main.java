package vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(
                tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
        tokens = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(
                    tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));

        tokens = scanner.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(
                tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            tokens = scanner.nextLine().split("\\s+");

            switch (tokens[0]) {
                case "Drive":
                    if (tokens[1].equalsIgnoreCase("Car")){
                        System.out.println(car.drive(Double.parseDouble(tokens[2])));
                    }else if (tokens[1].equalsIgnoreCase("Truck")){
                        System.out.println(truck.drive(Double.parseDouble(tokens[2])));

                    }else {
                        System.out.println(bus.drive(Double.parseDouble(tokens[2])));
                    }
                    break;
                case "Refuel":
                    if (tokens[1].equalsIgnoreCase("Car")){
                        try{
                            car.refuel(Double.parseDouble(tokens[2]));
                        }catch (IllegalArgumentException ex){
                            System.out.println(ex.getMessage());
                        }
                    }else if (tokens[1].equalsIgnoreCase("Truck")){
                       try {
                           truck.refuel(Double.parseDouble(tokens[2]));
                       }catch (IllegalArgumentException ex){
                           System.out.println(ex.getMessage());
                       }
                    }else {
                       try {
                           bus.refuel(Double.parseDouble(tokens[2]));
                       }catch (IllegalArgumentException ex){
                           System.out.println(ex.getMessage());
                       }
                    }
                    break;

                case  "DriveEmpty ":
                    System.out.println(bus.drive(Double.parseDouble(tokens[2]) - 1.4));
                    break;
            }

        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());

    }
}
