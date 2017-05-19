package perfectHashing.interfaces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import universalHashing.universalManager.HashManager;

public abstract class IHasher {

    protected int tableSize;

    protected ArrayList<Integer> keys;

    protected HashManager manager;

    public IHasher(int totalSize) {
        // TODO Auto-generated constructor stub
        this.tableSize = totalSize;
        keys = new ArrayList<Integer>();
        manager = HashManager.getInstance();
    }

    public void readFile(String fileName) throws IOException {
        FileReader file = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(file);
        while (reader.readLine() != null) {
            String line = reader.readLine();
            line = line.trim();
            String[] numbers = line.split(",");
            for (int i = 0; i < numbers.length; i++) {
                keys.add(Integer.valueOf(numbers[i].trim()));
            }
        }
        reader.close();
        file.close();
    }

    public abstract int insert();

    public abstract boolean search(int key);

}
