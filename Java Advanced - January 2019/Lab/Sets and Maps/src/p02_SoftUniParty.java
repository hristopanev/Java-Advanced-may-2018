import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class p02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        Set<String> guests = new TreeSet<>();

        while (!inputLine.equals("PARTY")) {

            guests.add(inputLine);
            inputLine = scanner.nextLine();
        }

        inputLine = scanner.nextLine();
        while (!inputLine.equals("END")){

            if (!guests.equals(inputLine)){
                guests.remove(inputLine);
            }


            inputLine = scanner.nextLine();
        }

        System.out.println(guests.size());
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}
