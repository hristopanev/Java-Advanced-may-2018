package farm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Food> foods = new ArrayList<>();

        while (true) {

            if (input.equalsIgnoreCase("End")){
                break;
            }
            String[] tokens = input.split("\\s+");
            Animal animal = null;
            if (tokens[0].equalsIgnoreCase("Cat")) {
                animal = new Cat(tokens[1], tokens[0], Double.parseDouble(tokens[2]),
                        tokens[3], tokens[4]);
            } else if (tokens[0].equalsIgnoreCase("Tiger")) {
                animal = new Tiger(tokens[1], tokens[0], Double.parseDouble(tokens[2]),
                        tokens[3]);
            } else if (tokens[0].equalsIgnoreCase("Mouse")) {
                animal = new Mouse(tokens[1], tokens[0], Double.parseDouble(tokens[2]),
                        tokens[3]);
            }else {
                animal = new Zebra(tokens[1], tokens[0], Double.parseDouble(tokens[2]),
                        tokens[3]);
            }

            input = scanner.nextLine();

            tokens = input.split("\\s+");

            Food food = null;
            if (tokens[0].equalsIgnoreCase("Vegetable")){
                food = new Vegetable(Integer.parseInt(tokens[1]));
            }else {
                food = new Meat(Integer.parseInt(tokens[1]));
            }

            animals.add(animal);
            foods.add(food);

            input = scanner.nextLine();
        }

        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).makeSound());
            try {
                animals.get(i).eat(foods.get(i));
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
