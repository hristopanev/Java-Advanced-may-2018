import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeObject {
    public static void main(String[] args) {


    String resourceFolder = "D:\\Project\\Java\\Java-Fundamentals\\Java Advanced - May 2018\\Lab\\Files and Streams\\resources";


    String seralizableObjectPath = resourceFolder + "object.ser";

        FootbalPlayer player = new FootbalPlayer("Cristiano Ronaldo",
                "50", "50", "Real Madrid");

        try( FileOutputStream fos =
                     new FileOutputStream(seralizableObjectPath)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(player);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
