package firstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        ArrayList<Person> people = new ArrayList<>();

        while (n-- >0){
            String[] tokens = reader.readLine().split("\\s+");

            try {
                Person person = new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]));
                people.add(person);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }

        Team team = new Team("Minior");
        for (Person person : people) {
            team.addPlayer(person);
        }

        System.out.printf("First team have %d players%n", team.getFirstTeam().size());
        System.out.printf("First team have %d players%n", team.getReserveTeam().size());
    }
}
