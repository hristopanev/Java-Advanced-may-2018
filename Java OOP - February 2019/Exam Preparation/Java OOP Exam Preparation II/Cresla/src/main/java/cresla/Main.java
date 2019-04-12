package cresla;

import cresla.core.ManagerImpl;
import cresla.interfaces.Manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Manager manager = new ManagerImpl();

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("Exit")){

            String[] tockens = input.split("\\s+");
            String command = tockens[0];
            List<String> params = Arrays.stream(tockens).skip(1).collect(Collectors.toList());
            String output = "";

            switch (command){
                case "Reactor":
                    output = manager.reactorCommand(params);
                    break;
                case "Module":
                    output = manager.moduleCommand(params);
                    break;

                case "Report":
                    output = manager.reportCommand(params);
                    break;
            }

            if ( output != null && !output.isEmpty()){
                System.out.println(output);
            }

            input = scanner.nextLine();
        }

        String output = manager.exitCommand(new ArrayList<String>());

        System.out.println(output);
    }
}
