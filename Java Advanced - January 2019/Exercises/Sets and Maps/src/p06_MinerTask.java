import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p06_MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resource = scanner.nextLine();

        Map<String, Integer> stack = new LinkedHashMap<>();

        while (!resource.equals("stop")){
            int quantity = Integer.parseInt(scanner.nextLine());


            if (!stack.containsKey(resource)){
                stack.put(resource, quantity);
            }else {
                stack.put(resource, stack.get(resource) +quantity);
            }

            resource = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : stack.entrySet()) {
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
