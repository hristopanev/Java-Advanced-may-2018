package search;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DateListSearch {

    public List<File> getPaths(File file, ArrayList<File> list) {
        if (file == null || list == null || !file.isDirectory()) {
            return  null;
        }

        File[] files = file.listFiles();

        for (File file1: files) {
            if (file1.isDirectory()) {
                getPaths(file1, list);
            }

            list.add(file1);
        }

        return list;
    }
}
