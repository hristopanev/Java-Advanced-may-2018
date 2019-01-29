import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class p08_NastedFolders {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\Hristo Panef\\Desktop\\Java Fundamentals Januar\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\Files-and-Streams";
        String outputPath = basePath + "\\p08_output.txt";

        PrintWriter writer = null;

        File folderToRead = new File(inputPath);
        int folderCount = 0;



        try {
            writer = new PrintWriter(new FileWriter(outputPath));

            ArrayDeque<File> filesToTraverse =
            new ArrayDeque<>(Arrays.asList(folderToRead));

            while (!filesToTraverse.isEmpty()){
                File currentFile = filesToTraverse.poll();
                if (currentFile.isDirectory()){
                    folderCount++;
                    filesToTraverse.addAll(Arrays.asList(currentFile.listFiles()));

                    writer.printf("%s%n", currentFile.getName());
                }
            }

            writer.println(folderCount + " folders");


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer != null){
                writer.close();
            }
        }
    }
}
