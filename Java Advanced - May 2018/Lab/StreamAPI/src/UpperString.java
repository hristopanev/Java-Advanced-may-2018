import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UpperString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //String[] inputName = reader.readLine().split("\\s+");

        //Arrays.stream(inputName)
        //        .map(name -> name.toUpperCase())
       //        .forEach(name -> System.out.print(name + " "));


        Arrays.stream(reader.readLine().split(" "))
                .map(n -> n.toUpperCase()).forEach(n -> System.out.print(n + " "));
    }
}
