import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class p01_consumerPrint {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Consumer<String> printer = str -> System.out.println(str);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(printer);
    }
}
