package P03_shape;

public class Rectangle extends Shape {
    public double sideA;
    public double sideB;

    public Rectangle (double sideA, double sideB){
        this.sideA = sideA;
        this.sideB = sideB;
    }


    @Override
    public void calculatePerimeter() {
        super.setPerimeter(this.sideA * 2 + this.sideB * 2);
    }

    @Override
    public void calculateArea() {
        super.setArea(this.sideA * this.sideB);
    }


}
