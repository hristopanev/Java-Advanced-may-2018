package p05.Border_Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> enters = new ArrayList<>();

        while (true){
            String [] input = reader.readLine().split("\\s+");
            if ("End".equals(input[0])){
                break;
            }

            Identifiable list  = null;

            if (input.length == 2){
                list = new Robot(input[0], input[1]);
            }else {
                list = new Citizen(input[0], Integer.parseInt(input[1]), input[2]);
            }

            enters.add(list);
        }

        String isEndWiths = reader.readLine();

        enters.stream().filter(e -> e.isFake(isEndWiths))
                .forEach(e -> {System.out.println(e.getId());});

    }
}