package demo;

public class Rectangle implements Drawable {
    private int width;
    private int heigth;
    private int height;

    public Rectangle(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    public Rectangle(String model) {
        setModel(model);
    }

    private void setModel(String model) {
    }


    @Override
    public void draw() {

        for (int i = 0; i < height; i++) {
            System.out.print("*");
            for (int k = 1; k < width - 1; k++) {
                System.out.print(" ");
                if (i == 0 || i == (height - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print(" "); System.out.print("*");   System.out.print("\n");
        }
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.width = height;
    }

    public int getHeight() {
        return width;
    }
}



