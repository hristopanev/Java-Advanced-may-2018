package P01_class_Box;

public class Box {
    private double lenght;
    private double width;
    private double height;

    public Box(double lenght, double width, double height){
        this.setLenght(lenght);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double getLenght() {
        return this.lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double GetVolume(){
        return this.lenght * this.width * this.height;
    }

    public double GetLateralSurfaceArea(){
        return this.lenght * this.height * 2 + this.width * this.height * 2;
    }

    public  double GetSurfaceArea(){
        return 2 * this.lenght * this.width + 2 * this.lenght * this.height + 2 * this.width * this.height;
    }
}
