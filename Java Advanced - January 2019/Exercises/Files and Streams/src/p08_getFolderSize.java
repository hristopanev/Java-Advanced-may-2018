import java.io.*;
import java.util.Arrays;

public class p08_getFolderSize {
    public static void main(String[] args) throws IOException {

        File file = new File("Exercises Resources");

        PrintWriter writer = new PrintWriter("folderSize.txt");

        long sum = Arrays.stream(file.listFiles())
                .filter(e -> !e.isDirectory())
                .mapToLong(e -> e.length())
                .sum();

        writer.write("Folder size: " + sum );
        writer.close();


    }
}

