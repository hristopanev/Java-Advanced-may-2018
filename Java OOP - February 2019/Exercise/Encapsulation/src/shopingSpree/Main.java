import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        try {
            List<String> _people = Arrays.stream(scanner.nextLine().split(";")).collect(Collectors.toList());
            _people.forEach(x -> {
                String[] personData = x.split("=");
                String name = personData[0];
                double money = Double.parseDouble(personData[1]);
                Person person = new Person(name, money);
                people.put(name, person);

            });
            List<String> _products = Arrays.stream(scanner.nextLine().split(";")).collect(Collectors.toList());
            _products.forEach(x -> {
                String[] productData = x.split("=");
                String name = productData[0];
                double cost = Double.parseDouble(productData[1]);
                Product product = new Product(name, cost);
                products.put(name, product);

            });

            String line;
            while (!"END".equals(line = scanner.nextLine())) {
                String name = line.split("\\s+")[0];
                String product = line.split("\\s+")[1];

                try{
                    people.get(name).buyProduct(products.get(product));
                    System.out.printf("%s bought %s%n", name, product);
                } catch (IllegalArgumentException exp){
                    System.out.printf("%s can't afford %s%n", name, product);
                }
            }

            people.entrySet().forEach(x -> System.out.println(x.getValue()));
        } catch (IllegalArgumentException exp){
            System.out.println(exp.getMessage());
        }
    }
}