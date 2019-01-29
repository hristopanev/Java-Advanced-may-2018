import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class p07_ListFiles {
    public static void main(String[] args) {

        String basePath = "C:\\Users\\Hristo Panef\\Desktop\\Java Fundamentals Januar\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\Files-and-Streams";
        String outputPath = basePath + "\\p07_output.txt";

        PrintWriter writer = null;

        File folderToRead = new File(inputPath);

        try {
            writer = new PrintWriter(new FileWriter(outputPath));

            File[] files = folderToRead.listFiles();

            for (File file : files) {
                if (!file.isDirectory()){
                    writer.printf("%s: [%d]%n", file.getName(), file.length());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer != null){
                writer.close();
            }
        }

    }
}
