package P03_shape;


public class Main {
    public static void main(String[] args) {

        Shape circle = new Circle(3.45);
        Shape rect  = new Rectangle(5, 10);

        circle.calculatePerimeter();
        System.out.println(circle.getPerimeter());
        circle.calculateArea();
        System.out.println(circle.getArea());

        rect.calculatePerimeter();
        System.out.println(rect.getPerimeter());
        rect.calculateArea();
        System.out.println(rect.getArea());
    }
}
