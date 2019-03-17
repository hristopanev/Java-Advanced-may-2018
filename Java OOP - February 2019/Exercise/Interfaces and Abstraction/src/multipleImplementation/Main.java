package multipleImplementation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            List<Birthable> birthdays = new ArrayList<>();

            String line;
            while (!"End".equals(line = scanner.nextLine())){
                String[] data = line.split(" ");
                switch (data[0]){
                    case "Citizen" :
                        Birthable citizen = new Citizen(data[1], Integer.parseInt(data[2]), data[3], data[4]);
                        birthdays.add(citizen);
                        break;
                    case "Robot" :
                        Identifiable robot = new Robot(data[1], data[2]);
                        break;
                    case "Pet" :
                        Birthable pet = new Pet(data[1], data[2]);
                        birthdays.add(pet);
                }
            }

            String yearToSearch = scanner.nextLine();

            for (Birthable birthday : birthdays) {
                if (birthday.getBirthDate().endsWith(yearToSearch)){
                    System.out.println(birthday.getBirthDate());
                }
            }


    }
}
