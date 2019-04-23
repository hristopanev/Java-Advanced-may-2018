package P03_manking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String[] studentTokens = reader.readLine().split("\\s+");
            String[] workertTokens = reader.readLine().split("\\s+");

            Human student = new Student(studentTokens[0], studentTokens[1], studentTokens[2]);

            Human worker = new Worker(workertTokens[0], workertTokens[1], Double.parseDouble(workertTokens[2]),
                    Double.parseDouble(workertTokens[3]));

            System.out.println(student);
            System.out.println(worker);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }



    }

}
