package main;

import java.io.IOException;
import java.util.ArrayList;

import perfectHashing.interfaces.IHasher;
import perfectHashing.pHasher.OneLevelHashing;
import perfectHashing.pHasher.TwoLevelHashing;

public class Main {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        String filePath = "C:\\Users\\Muhammed\\Desktop\\testCases_lab4\\1.txt";
        ArrayList<Integer> keys = fileReader.Reader.readFile(filePath);
        IHasher oneLevel = new OneLevelHashing(keys.size());
        IHasher twoLevel = new TwoLevelHashing(keys.size());
        int collsion1 = 0, collsion2 = 0;
        for (int i = 0; i < keys.size(); i++) {
            collsion1 += oneLevel.insert(keys.get(i));
            collsion2 += twoLevel.insert(keys.get(i));
        }
        System.out.println(collsion1);

        System.out.println(collsion2);
    }

}
