import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileReader {
    public static void main(String[] args) {

        String resourceFolder = "D:\\Project\\Java\\Java-Fundamentals\\Java Advanced - May 2018\\Lab\\Files and Streams\\resources";


        Path pathInput = Paths.get
                ("D:\\Project\\Java\\Java-Fundamentals\\" +
                        "Java Advanced - May 2018\\Lab\\Files and Streams\\resources\\input.txt");

        Path pathOutput = Paths.get
                ("D:\\Project\\Java\\Java-Fundamentals\\" +
                        "Java Advanced - May 2018\\Lab\\Files and Streams\\resources\\input.txt");


        String rootDirectoryPath = resourceFolder + "Files-and-Streams";

        File rootDir = new File(rootDirectoryPath);

        File[] files = rootDir.listFiles();

        if (files == null){
            return;
        }

        for (File file : files) {
            if (!file.isDirectory()){
                System.out.printf("%s: [%s in bytes]%n", file.getName(),  file.length());
            }

        }




    }
}