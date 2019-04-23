import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resoursesBag = new LinkedHashMap<>();

        while (true){

            String resourse = scanner.nextLine();

            if ("stop".equals(resourse)){
                break;
            }
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resoursesBag.containsKey(resourse)){
                resoursesBag.put(resourse, quantity);
            }else {
                resoursesBag.put(resourse, resoursesBag.get(resourse) + quantity);

            }
        }

        for (Map.Entry<String, Integer> entry : resoursesBag.entrySet()) {

            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
