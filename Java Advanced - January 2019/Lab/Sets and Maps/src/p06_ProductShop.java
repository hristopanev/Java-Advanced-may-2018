import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();
        String line = scanner.nextLine();

        while (!line.equals("Revision")){
            String[] data = line.split(", ");

            String shopName = data[0];
            String productName = data[1];
            double productPrice = Double.parseDouble(data[2]);

            LinkedHashMap<String, Double> products = new LinkedHashMap<>();
            if (shops.containsKey(shopName)) {
                products = shops.get(shopName);
            }

            products.put(productName, productPrice);
            shops.put(shopName, products);


            line = scanner.nextLine();
        }

        for (String shopName : shops.keySet()) {
            System.out.println(shopName +"->");
            LinkedHashMap<String, Double> products = shops.get(shopName);

            for (String product : products.keySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", product, products.get(product));
            }
        }
    }
}
