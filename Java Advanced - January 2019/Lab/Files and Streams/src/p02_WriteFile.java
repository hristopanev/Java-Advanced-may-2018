import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class p02_WriteFile {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Hristo Panef\\Desktop\\Java Fundamentals Januar\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputFile = "C:\\Users\\Hristo Panef\\Desktop\\Java Fundamentals Januar\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\new output.txt";


        List<Character> punctuation = Arrays.asList(',', '.', '!', '?');

        FileOutputStream outputStream = null;
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
            outputStream = new FileOutputStream(outputFile);

            int byteData = inputStream.read();

            while (byteData >= 0){
                if (!punctuation.contains((char)byteData)){
                    outputStream.write(byteData);
                }

                byteData = inputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream != null){
                inputStream.close();
            }

            if (outputStream != null){
                outputStream.close();
            }
        }

    }
}
