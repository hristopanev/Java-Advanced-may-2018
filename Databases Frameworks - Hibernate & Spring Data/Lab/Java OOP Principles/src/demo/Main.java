package demo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Drawable[] drawables = {
                new Circle(5),
                new Rectangle(10, 15)
        };

        Arrays.stream(drawables)
                .forEach(Drawable::draw);
        }
}
