package P02_class_Box_Data_Validation;

public class Box {
    private double lenght;
    private double width;
    private double height;

    public Box(double lenght, double width, double height) {
        this.setLenght(lenght);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLenght(double lenght) {
        if (lenght <= 0){
            throw  new  IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.lenght = lenght;
    }

    private void setWidth(double width) {
        if (width <= 0){
            throw  new  IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0){
            throw  new  IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double calcSurfArea(){
        return 2 * this.lenght * this.width + 2 * this.lenght * this.height + 2 * this.width * this.height;
    }

    public double calcLateralSurfArea(){
        return this.lenght * this.height * 2 + this.width * this.height * 2;

    }

    public double calcVolume(){
        return this.lenght * this.width * this.height;
    }
}
