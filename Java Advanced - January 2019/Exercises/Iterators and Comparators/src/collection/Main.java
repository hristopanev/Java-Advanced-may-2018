package collection;

import listlyterator.ListIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> data = Arrays.stream(reader.readLine().split("\\s+"))
                .skip(1)
                .collect(Collectors.toCollection(ArrayList::new));

        ListIterator listIterator = new ListIterator(data);
        String line = reader.readLine();

        while (!line.equalsIgnoreCase("end")){


            if (line.equalsIgnoreCase("move")){
                System.out.println(listIterator.move());
            }else if (line.equalsIgnoreCase("print")){
                System.out.println(listIterator.print());

            }else if (line.equalsIgnoreCase("hasNext")){
                System.out.println(listIterator.hasNext());

            }else if (line.equalsIgnoreCase("PrintAll")){
                for (String str : listIterator) {
                    System.out.print(str + " ");
                }
                System.out.println();
            }

            line = reader.readLine();
        }
    }
}
