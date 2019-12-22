package search;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DateListSearch dateSearch = new DateListSearch();

        // Here put your directory path

        String datePath = "C:\\Users\\";
        File dateListFile = new File(datePath);

        List<File> files = dateSearch.getPaths(dateListFile, new ArrayList<>());


        files.forEach(file -> {
            try {
                System.out.println(file.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Search
        System.out.println("\n");
        String userInputString = "Java";

        for (File file : files) {
            String fileName = file.getName();

            if (fileName.equalsIgnoreCase(userInputString + ".txt")) {
                System.out.println("DateName: " + fileName + " is found");
                try {
                    System.out.println(file.getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
