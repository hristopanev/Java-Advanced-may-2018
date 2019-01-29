import java.io.*;

public class p05_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String basePath = "C:\\Users\\Hristo Panef\\Desktop\\Java Fundamentals Januar\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\p05_output.txt";

        BufferedReader reader = null;
        PrintWriter writer = null;
        int row = 1;

        try {
            reader = new BufferedReader(new FileReader(inputPath));
            writer = new PrintWriter(new FileWriter(outputPath));

            String line = reader.readLine();

            while (line != null){
                if (row % 3 == 0){
                    writer.print(line);
                    writer.print('\n');
                }

                row++;

                line = reader.readLine();
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (reader != null){
                reader.close();
            }
            if (writer != null){
                writer.close();
            }
        }


    }
}
