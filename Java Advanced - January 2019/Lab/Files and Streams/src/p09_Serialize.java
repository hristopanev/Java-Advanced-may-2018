import java.io.*;
import java.util.Scanner;

public class p09_Serialize {
    public static void main(String[] args) {

        Cube cube = new Cube();
        cube.coler = "green";
        cube.width = 15.3d;
        cube.height = 12.4d;
        cube.depth = 3d;

        String basePath = "C:\\Users\\Hristo Panef\\Desktop\\Java Fundamentals Januar\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputFileName = basePath + "\\input.txt";
        String outputFileName = basePath + "\\p09_output.txt";

        Scanner scanner = null;
        FileWriter writer = null;

        try (
            ObjectOutputStream objectOutputStream
                        = new ObjectOutputStream(new FileOutputStream(inputFileName))) {

            objectOutputStream.writeObject(cube);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class Cube implements Serializable {
    public String coler;
    public double height;
    public double width;
    public double depth;
}
