package mood3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" \\| ");
        String userName = tokens[0];
        String type = tokens[1];
        Integer level = Integer.parseInt(tokens[3]);

        Character hero;
        if (type.equals(Demon.CHARACTER_TYPE)){
            hero = new Demon(userName, level, Double.parseDouble(tokens[2]));
        }else {
            hero = new Archangel(userName, level, Integer.parseInt(tokens[2]));
        }

        System.out.println(hero.toString());

    }
}
