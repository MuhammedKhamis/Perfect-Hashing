package main;

import java.io.IOException;
import java.util.ArrayList;

import perfectHashing.interfaces.IHasher;
import perfectHashing.pHasher.TwoLevelHashing;

public class Main {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        String filePath = "C:\\Users\\Muhammed\\git\\Perfect-Hashing\\PerfectHashing\\tests\\4.txt";
        ArrayList<Integer> keys = fileReader.Reader.readFile(filePath);
        // IHasher oneLevel = new OneLevelHashing(keys.size());
        IHasher twoLevel = new TwoLevelHashing(keys.size());
        // collsion1 = oneLevel.insert(keys);
        long tests = 0;
        for (int i = 0; i < 1000; i++) {
            long start = System.currentTimeMillis();
            twoLevel.insert(keys);
            long end = System.currentTimeMillis();
            tests += (end - start);
        }
        System.out.println(tests / 1000);

    }

}
