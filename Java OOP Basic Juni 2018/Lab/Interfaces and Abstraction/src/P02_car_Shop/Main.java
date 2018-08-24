package P02_car_Shop;

public class Main {
    public static void main(String[] args) {
        Car car = new Ford(
                "Germany", "Focus", "Red", 105);

        System.out.println(car.toString());
    }
}
