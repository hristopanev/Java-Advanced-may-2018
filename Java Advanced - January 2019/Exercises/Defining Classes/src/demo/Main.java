package demo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();

        ArrayList<Vehicles> cars = new ArrayList<>();
        ArrayList<Vehicles> trucks = new ArrayList<>();


        while (!data.equals("End")) {
            String[] tokens = data.split("\\s+");

            Vehicles vehicle = new Vehicles(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]));


            if (vehicle.getType().equals("Car")){
                cars.add(vehicle);
            }else {
                trucks.add(vehicle);
            }

            data = scanner.nextLine();
        }

        data  = scanner.nextLine();
        while (!data.equals("Close the Catalogue")){

            for (Vehicles truck : trucks) {
                if (truck.getModel().equals(data)){
                    System.out.println(truck.toString());
                }
            }

            for (Vehicles car : cars) {
                if (car.getModel().equals(data)){
                    System.out.println(car.toString());
                }
            }
            data = scanner.nextLine();
        }

        double carHPAvg = 0;
        double carHpSum = 0;
        double truckHPAvg = 0;
        double truckHpSum = 0;

        if (!cars.isEmpty()){
            for (Vehicles car : cars) {
                carHpSum += car.getHorsepower();
            }
            carHPAvg = carHpSum / cars.size();
        }
        System.out.println(String.format("Cars have average horsepower of: %.2f.", carHPAvg));

        if (!cars.isEmpty()){
            for (Vehicles truck : trucks) {
                truckHpSum += truck.getHorsepower();
            }
            truckHPAvg = truckHpSum / trucks.size();
        }
        System.out.println(String.format("Trucks have average horsepower of: %.2f.", truckHPAvg));
    }
}
