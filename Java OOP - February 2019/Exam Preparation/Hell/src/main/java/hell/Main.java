package hell;

import hell.entities.manager.ManagerImpl;
import hell.interfaces.Hero;
import hell.interfaces.Manager;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<String, Hero> localHeroes;

    public static void main(String[] args) {
        Manager manager = new ManagerImpl();
        Scanner scanner = new Scanner(System.in);

        String commandLine = scanner.nextLine();

        while (!commandLine.equalsIgnoreCase("quit")) {
            String[] commandArgs = commandLine.split("\\s+");
            String commandName = commandArgs[0];

            String result = "";
            switch (commandName) {
                case "Hero":
                    result = manager.addHero(Arrays.asList(commandArgs[1], commandArgs[2]));
                    break;
                case "Item":
                    result = manager.addItem(Arrays.asList(commandArgs));
                    break;
                case "Recipe":
                    result = manager.addRecipe(Arrays.asList(commandArgs));
                    break;
            }
            System.out.println(result);

            commandLine = scanner.nextLine();
        }
    }
}