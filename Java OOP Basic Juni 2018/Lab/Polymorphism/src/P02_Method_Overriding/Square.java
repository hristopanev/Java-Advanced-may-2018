package P02_Method_Overriding;

public class Square extends Rectangle {


    public Square(double sideA) {
        super(sideA);
    }

    public double area(){
        return super.getSideA() * super.getSideA();
    }
}
