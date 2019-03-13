package animalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        try {
            Chicken chicken = new Chicken(name, age);

            System.out.printf("Chicken %s (age %d) can produce %.0f eggs per day.%n",
                                chicken.getName(), chicken.getAge(), chicken.productPerDay());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
