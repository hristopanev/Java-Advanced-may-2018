import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(reader.readLine());

        String[] inputLine = reader.readLine().split("\\s+");
        ArrayDeque<String> input = new ArrayDeque<>();
        ArrayDeque<String> restReservation = new ArrayDeque<>();
        List<String> reservation = new ArrayList<>();
        List<Integer>  intResult = new ArrayList<>();
        String alfa = "";
        int sum = 0;
        int moment= 0;
        int restSum = 0;


        for (int i = 0; i < inputLine.length; i++) {
            input.add(inputLine[i]);
        }

        for (int i = input.size() - 1; i >= 0; i--) {
            if (!Character.isLetter(input.peekLast().charAt(0))){
                input.pollLast();
            }
        }

        System.out.println();


        String line = "";
        while (!input.isEmpty()) {

            if (Character.isLetter(input.peekLast().charAt(0))){
                if (reservation.isEmpty()){
                    reservation.add(input.peekLast());
                    alfa = input.pollLast();
                }else {
                    restReservation.add(input.pollLast());
                }
            }else {
                int intee = Integer.parseInt(input.peekLast());
                sum += Integer.parseInt(input.pollLast());
                if (sum >= capacity){

                    System.out.print(alfa + " -> ");
                    for (int i = 0; i < intResult.size(); i++) {
                        if (i == intResult.size() - 1){
                            System.out.println(intResult.get(i));
                        }else {
                            System.out.print(intResult.get(i) + ", ");
                        }
                    }
                    if (sum == capacity){
                    intResult = new ArrayList<>();
                    }else {
                        intResult = new ArrayList<>();
                        intResult.add(intee);
                    }

                    if (!restReservation.isEmpty()){
                        alfa = restReservation.pop();
                    }
                    sum = 0;
                }else {

                    intResult.add(intee);
                }
            }

        }
    }
}
