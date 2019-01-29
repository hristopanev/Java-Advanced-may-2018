import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class p03_CopyBytes {
    public static void main(String[] args) throws IOException {
        String basePath = "C:\\Users\\Hristo Panef\\Desktop\\Java Fundamentals Januar\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\new output.txt";


        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(inputPath);
            outputStream = new FileOutputStream(outputPath);

            int byteDate = inputStream.read();

            while (byteDate > 0) {

                if (byteDate == ' ' || byteDate == '\n') {

                    outputStream.write(byteDate);
                }else {
                    String number = String.valueOf(byteDate);

                    for (int i = 0; i < number.length(); i++) {
                        outputStream.write(number.charAt(i));
                    }
                }

                byteDate = inputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
