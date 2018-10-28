package p06.Birday_Celebration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Birthable> enters = new ArrayList<>();

        while (true){
            String [] input = reader.readLine().split("\\s+");
            if ("End".equals(input[0])){
                break;
            }

            Birthable list  = null;

            switch (input[0]) {
                case "Citizen":
                    list = new Citizen(input[1], Integer.parseInt(input[2]), input[3], input[4]);
                    break;
                case "Pet":
                    list = new Pet(input[1], input[2]);
                    break;
                default:
                    continue;
            }

            enters.add(list);
        }

        String year = reader.readLine();

        enters.stream().filter(e -> e.isBornIn(year))
                .forEach(e -> {System.out.println(e.getBirthdate());});

    }
}