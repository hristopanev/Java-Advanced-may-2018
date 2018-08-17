package P01_class_Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.parseDouble(reader.readLine());
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());

        Box box = new Box(length, width, height);



        System.out.println(String.format("Surface Area - %.2f", box.GetSurfaceArea()));
        System.out.println(String.format("Lateral Surface Area - %.2f", box.GetLateralSurfaceArea()));
        System.out.println(String.format("Volume - %.2f", box.GetVolume()));
    }
}
