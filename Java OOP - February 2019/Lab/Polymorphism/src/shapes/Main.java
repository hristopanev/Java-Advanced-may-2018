package shapes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape rect = new Rectangle(3, 4);
        Rectangle rect2 = new Rectangle(5, 6);
        Shape circ = new Circle(5);
        Circle circ2 = new Circle(6);

        List<Shape> shapes = new ArrayList<>();

        shapes.add(rect);
        shapes.add(rect2);
        shapes.add(circ);
        shapes.add(circ2);

        for (Shape shape : shapes) {
            System.out.println("Area");
            System.out.println(shape.calculateArea());
            System.out.println("Perimeter");
            System.out.println(shape.calculatePerimeter());
        }
    }

}
