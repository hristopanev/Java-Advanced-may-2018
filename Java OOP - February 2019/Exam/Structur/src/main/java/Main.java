import core.ManagerControllerImpl;
import core.interfaces.ManagerController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ManagerController managerController = new ManagerControllerImpl();

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("exit")) {

            String result = "";
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            try {


                switch (command) {
                    case "AddPlayer":
                        result = managerController.addPlayer(tokens[1], tokens[2]);
                        break;
                    case "AddCard":
                        result = managerController.addCard(tokens[1], tokens[2]);
                        break;
                    case "AddPlayerCard":
                        result = managerController.addPlayerCard(tokens[1], tokens[2]);
                        break;
                    case "Fight":
                        result = managerController.fight(tokens[1], tokens[2]);
                        break;
                    case "Report":
                        result = managerController.report();
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }


            System.out.println(result);
            input = scanner.nextLine();
        }
    }
}
