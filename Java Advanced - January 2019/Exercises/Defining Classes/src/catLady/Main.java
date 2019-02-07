package catLady;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayList<Cat> cats = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String breed = tokens[0];
            String name = tokens[1];
            double param = Double.parseDouble(tokens[2]);

            Cat cat = null;

            if (breed.equals("Siamese ")) {
                cat = new Siamese(name, param);
            } else if (breed.equals("Cymric ")) {
                cat = new Cymric(name, param);
            } else {
                cat = new StreetExtraordinaire(name, param);
            }

            cats.add(cat);

            input = scanner.nextLine();
        }

        String name = scanner.nextLine();

        for (Cat cat : cats) {
            if (cat.getName().equals(name)){
                System.out.println(cat);
                break;
            }
        }

    }
}
