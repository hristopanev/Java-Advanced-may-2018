import java.io.*;
import java.util.Scanner;

public class p04_ExtractInteger {
    public static void main(String[] args) throws IOException {
        String basePath = "C:\\Users\\Hristo Panef\\Desktop\\Java Fundamentals Januar\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputFileName = basePath + "\\input.txt";
        String outputFileName = basePath + "\\p04_output.txt";

        Scanner scanner = null;
        FileWriter writer = null;

        try {
            scanner = new Scanner(new FileInputStream(inputFileName));
            writer = new FileWriter(outputFileName);

            while (scanner.hasNext()){
                if (scanner.hasNextInt()){
                    writer.write(String.valueOf(scanner.nextInt()));
                    writer.write('\n');
                }
                scanner.next();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (scanner != null){
                scanner.close();
            }

            if (writer != null){
                writer.close();
            }
        }
    }
}
