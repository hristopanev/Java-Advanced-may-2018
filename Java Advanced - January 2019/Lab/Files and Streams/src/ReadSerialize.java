import java.io.*;
import java.util.Scanner;

public class ReadSerialize {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\Hristo Panef\\Desktop\\Java Fundamentals Januar\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputFileName = basePath + "\\input.txt";
        String outputFileName = basePath + "\\p09_output.txt";

        Scanner scanner = null;
        FileWriter writer = null;

        try (
                ObjectInputStream objectStream
                        = new ObjectInputStream(new FileInputStream(inputFileName))) {

            Cube restored = (Cube) objectStream.readObject();

            System.out.printf("%s, %f, %f, %f",
                    restored.coler,
                    restored.width,
                    restored.height,
                    restored.depth);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
