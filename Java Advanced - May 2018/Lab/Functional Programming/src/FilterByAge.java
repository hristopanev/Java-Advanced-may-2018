import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> people = new LinkedHashMap<>();

        int count = Integer.parseInt(reader.readLine());

        while (count -- > 0){
            String[]  input = reader.readLine().split(", ");

            people.putIfAbsent(input[0], Integer.parseInt(input[1]));
        }

        String condition = reader.readLine(); // young, older
        int ageCondition = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        Predicate<Integer> conditionFunc = Conditions(ageCondition, condition);

        for (Map.Entry<String, Integer> stringIntegerEntry : people.entrySet()) {
            if (conditionFunc.test(stringIntegerEntry.getValue())){
                GetPrint(format, stringIntegerEntry).accept(stringIntegerEntry);
            }
        }
    }

    private static Consumer<Map.Entry<String, Integer>> GetPrint(String format, Map.Entry<String, Integer> entry) {
        if ("name".equals(format)){
            return  e ->  System.out.printf("%s%n", entry.getKey());
        }else if ("age".equals(format)){
            return  e ->  System.out.printf("%d%n", entry.getValue());
        }else {
            return  e ->  System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
    }

    private static Predicate<Integer> Conditions(int ageCondition, String condition){
        if ("younger".equals(condition)){
            return x -> x < ageCondition;
        }else
            return x -> x >= ageCondition;
    }
}
