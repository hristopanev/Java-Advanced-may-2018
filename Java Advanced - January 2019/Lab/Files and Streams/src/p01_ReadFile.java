import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class p01_ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Hristo Panef\\Desktop\\Java Fundamentals Januar\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = null;

        try {

            inputStream = new FileInputStream(path);

            int byteDate = inputStream.read();
            while (byteDate >= 0) {
                System.out.print(Integer.toBinaryString(byteDate) + " ");

                byteDate = inputStream.read();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            if (inputStream != null){
                inputStream.close();
            }
        }
    }
}
