package P03_shape;

public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;

    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter( 2 * Math.PI * this.radius);
    }

    @Override
    public void calculateArea() {
        super.setArea(Math.PI * (this.radius * this.radius));
    }
}
