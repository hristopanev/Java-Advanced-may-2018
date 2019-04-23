package P03_car_Shop_Extend;

public class Main {
    public static void main(String[] args) {

        Sellable ford = new Ford("Focus", "D", "Red", 100,
                14.5555);
        Rentable audi = new Audi("A7", "Red", 23, "De",
                3, 3.4);


        printCarInfo(ford);
        printCarInfo(audi);
    }

    private static void printCarInfo(Car car) {
        System.out.println(String.format(
                "%s is %s color and have %s horse power",
                car.getModel(),
                car.getColor(),
                car.getHorsePower()));
        System.out.println(car.toString());

    }
}
