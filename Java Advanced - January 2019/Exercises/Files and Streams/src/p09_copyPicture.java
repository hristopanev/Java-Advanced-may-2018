import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class p09_copyPicture {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("java.jpg");

        byte[] buffer = inputStream.readAllBytes();

        FileOutputStream outputStream = new FileOutputStream("copyJava.jpg");

        outputStream.write(buffer);
        outputStream.close();
    }
}
