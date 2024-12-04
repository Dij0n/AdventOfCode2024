package advent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Helpers {

    public static List<String> parseFile(String string){
        String filePath = string;
        ArrayList<String> lineList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                lineList.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return lineList;
    }

    public static String parseFileOneString(String string){
        String filePath = string;

        try {
            return  Files.readString(Path.of(filePath));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return "";
    }

}
