package hell;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizzard;
import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.*;
import hell.io.ConsoleInputReader;
import hell.io.ConsoleOutputWriter;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    private static Map<String, Hero> heroes = new LinkedHashMap<>();

    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();

        while (true) {
            String[] tokens = reader.readLine().split("\\s+");

            String command = tokens[0];
            String[] arguments = Arrays.stream(tokens).skip(1).toArray(String[]::new);

            String result = interpretCommand(command, arguments);
            writer.writeLine(result);

            if ("Quit".equalsIgnoreCase(command)) {
                break;
            }
        }
    }

    private static String interpretCommand(String command, String[] args) {
        Hero hero;

        switch (command){
            case "Hero":
                hero = createHero(args[0], args[1]);

                heroes.put(hero.getName(), hero);

                return String.format("Created %s - %s",
                        hero.getClass().getSimpleName(),
                        hero.getName());

            case "Item":
                hero = heroes.get(args[1]);
                Item commonItem = new CommonItem(
                        args[0],
                        Integer.parseInt(args[2]),
                        Integer.parseInt(args[3]),
                        Integer.parseInt(args[4]),
                        Integer.parseInt(args[5]),
                        Integer.parseInt(args[6])
                );
                hero.addItem(commonItem);
                return String.format("Added item - %s to Hero - %s",
                        commonItem.getName(),
                        hero.getName());

            case "Recipe":
                hero = heroes.get(args[1]);
                Recipe recipeItem = new RecipeItem(
                        args[0],
                        Integer.parseInt(args[2]),
                        Integer.parseInt(args[3]),
                        Integer.parseInt(args[4]),
                        Integer.parseInt(args[5]),
                        Integer.parseInt(args[6]),
                        Arrays.stream(args).skip(7).collect(Collectors.toList())
                );
                hero.addItem(recipeItem);
                return String.format("Added recipe - %s to Hero - %s",
                        recipeItem.getName(),
                        hero.getName());
            case "Inspect":
                return "inspect";
            case "Quit":
                return "quit";
        }
        return null;
    }

    private static Hero createHero(String name, String type) {
        switch (type){
            case "Barbarian":
                return new Barbarian(name, new HeroInventory());
            case "Assassin":
                return new Assassin(name, new HeroInventory());
            case "Wizard":
                return new Wizzard(name, new HeroInventory());
        }
        return null;
    }
}