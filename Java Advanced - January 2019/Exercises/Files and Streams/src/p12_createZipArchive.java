import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class p12_createZipArchive {
    public static void main(String[] args) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("files.zip");

        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);

        FileInputStream inputStream = new FileInputStream("input.txt");

        zipOutputStream.putNextEntry(new ZipEntry("input.txt"));
        zipOutputStream.write(inputStream.readAllBytes());
        zipOutputStream.close();
    }
}
