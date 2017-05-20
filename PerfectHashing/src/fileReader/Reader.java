package fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Reader {


    public static ArrayList<Integer> readFile(String fileName) throws IOException {
        ArrayList<Integer> keys = new ArrayList<>();
        FileReader file = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(file);
        while (reader.ready()) {
            String line = reader.readLine();
            line = line.trim();
            String[] numbers = line.split(",");
            for (int i = 0; i < numbers.length; i++) {
                keys.add(Integer.valueOf(numbers[i].trim()));
            }
        }
        reader.close();
        file.close();
        return keys;
    }

}
