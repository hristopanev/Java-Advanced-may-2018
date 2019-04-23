import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;


public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Double> input = Arrays.stream(reader.readLine().split(", "))
                .map(Double::parseDouble).collect(Collectors.toList());

        Function<List<Double>, List<Double>> addVAT = vat -> {
            List<Double> vats = new ArrayList<>();
            for (Double v : vat) {
                vats.add(v * 1.2);
            }
            return vats;
        };

        input = addVAT.apply(input);

        Consumer<List<Double>> print = vat -> {
            System.out.println("Prices with VAT:");
            for (Double v : vat) {
                System.out.printf("%.2f%n", v);
            }
        };

        print.accept(input);
    }
}
