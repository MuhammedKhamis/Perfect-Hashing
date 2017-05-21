package main;

import java.io.IOException;
import java.util.ArrayList;

import perfectHashing.interfaces.IHasher;
import perfectHashing.pHasher.OneLevelHashing;
import perfectHashing.pHasher.TwoLevelHashing;

public class Main {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        String filePath = "C:\\Users\\Muhammed\\git\\Perfect-Hashing\\PerfectHashing\\tests\\4.txt";
        ArrayList<Integer> keys = fileReader.Reader.readFile(filePath);
        //IHasher oneLevel = new OneLevelHashing(keys.size());
        IHasher twoLevel = new TwoLevelHashing(keys.size());
        //int collsion1 = oneLevel.insert(keys);
       // System.out.println("One level : "+ collsion1);
        int collsion2 = twoLevel.insert(keys);
        System.out.println("Two levels : "+ collsion2);

    }

}
