package rawData;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<String> topPower = new ArrayList<>();
        ArrayList<String> fewPressure = new ArrayList<>();

        while (n-- >0) {

            String[] data = scanner.nextLine().split("\\s+");

            String model = data[0];
            int enginePower = Integer.parseInt(data[2]);
            double tiresPressure = (Double.parseDouble(data[5]) + Double.parseDouble(data[7])
                    + Double.parseDouble(data[9]) + Double.parseDouble(data[11])) / 4;

            if (enginePower > 250){
                topPower.add(model);
            }

            if (tiresPressure < 1){
                fewPressure.add(model);
            }
        }

        String command = scanner.nextLine();

        if (command.equalsIgnoreCase("fragile")){
            for (String car : fewPressure) {
                System.out.println(car);
            }
        }else {
            for (String car : topPower) {
                System.out.println(car);
            }
        }
    }
}
