package helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel_Chaika1
 * Read CSV file from the src/main/resources
 */
public class CSVReader {

    public String[] read(String pathToFile, int lineNumber) throws IOException {

        String csvFile = absolutePath(pathToFile);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        List<String> lines = new ArrayList<>();
        String line;
        String cvsSplitBy = ";";
        String[] data;

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        line = lines.get(lineNumber);

        try {
            data = line.split(cvsSplitBy);
            return data;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param path to the CSV file
     * @return absolute path to the CSV file
     */
    private static String absolutePath(String path) {
        File f = new File(path);
        return (f.getAbsolutePath());
    }
}