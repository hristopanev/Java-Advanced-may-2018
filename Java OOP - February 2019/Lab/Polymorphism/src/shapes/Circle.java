package shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    double calculatePerimeter() {
        return  2 * Math.PI * this.radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * this.radius * this.radius;
    }
}
