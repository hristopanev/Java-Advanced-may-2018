package panzer;

import panzer.contracts.Manager;
import panzer.manager.ManagerImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Manager manager = new ManagerImpl();
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("Terminate")) {
            String[] tokens = input.split("\\s+");
            List<String> arguments = Arrays.stream(tokens)
                    .skip(1).collect(Collectors.toList());

            String result = null;
            switch (tokens[0]) {
                case "Vehicle":
                result = manager.addVehicle(arguments);
                    break;
                case "Part":
                    result = manager.addPart(arguments);
                    break;
                case "Inspect":
                    result = manager.inspect(arguments);
                    break;
                case "Battle":
                    result = manager.battle(arguments);
            }

            System.out.println(result);
            input = scanner.nextLine();
        }

    }
}
