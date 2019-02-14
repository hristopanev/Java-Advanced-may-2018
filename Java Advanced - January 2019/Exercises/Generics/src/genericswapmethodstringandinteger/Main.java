package genericswapmethodstringandinteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Box<String>> boxOfStrings = new ArrayList<>();
        List<Box<String>> boxofIntegers = new ArrayList<>();

        while (n-- > 0){
            String line = reader.readLine();

            Box box = null;

            try {
                int number = Integer.parseInt(line);
                box = new Box<>(number);
                boxofIntegers.add(box);
            }catch (Exception e){
                box = new Box<>(line);
                boxOfStrings.add(box);
            }
        }


        int[] indexes = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (boxofIntegers.isEmpty()){
            swapValues(boxOfStrings, indexes[0], indexes[1]);

            for (Box box : boxOfStrings) {
                System.out.println(box.toString());
            }
        }else {
            swapValues(boxofIntegers, indexes[0], indexes[1]);

            for (Box box : boxofIntegers) {
                System.out.println(box.toString());
            }
        }
    }

    public static <T> void swapValues(List<T> box, int firstIndex, int secondIndex){
        T temp = box.get(firstIndex);
        box.set(firstIndex, box.get(secondIndex));
        box.set(secondIndex, temp);
    }
}
