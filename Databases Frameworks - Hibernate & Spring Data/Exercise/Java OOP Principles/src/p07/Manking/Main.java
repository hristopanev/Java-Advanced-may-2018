package p07.Manking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String [] studentInput = reader.readLine().split("\\s+");
            String [] workerInput = reader.readLine().split("\\s+");

            Human student = new Student(studentInput[0], studentInput[1], studentInput[2]);
            Human worker = new Worker(workerInput[0], workerInput[1],  Double.parseDouble(workerInput[2])
                    ,Double.parseDouble(workerInput[3]));

            System.out.println(student);
            System.out.println();
            System.out.println(worker);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }

}
