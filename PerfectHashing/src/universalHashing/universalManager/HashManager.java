package universalHashing.universalManager;

import java.util.Random;

import universalHashing.hashFunction.HashFunction;
import universalHashing.interfaces.IHash;

public class HashManager {

    private static HashManager manager;

    private boolean numbers[];

    private static final int maxNumber = 10000000;

    private int largestPrime;
    private Random rand;

    private HashManager() {
        // TODO Auto-generated constructor stub
        numbers = new boolean[maxNumber];
        rand = new Random();
        getPrime();

    }

    private void getPrime() {
        for (int i = 2; i < maxNumber; i++) {
            if (numbers[i] == false) {
                largestPrime = i;
                for (int j = 2 * i; j < maxNumber; j += i) {
                    numbers[j] = true;
                }
            }
        }
    }

    public IHash getHashFunction(int tableSize) {
        int a = rand.nextInt(largestPrime - 1) + 1;
        int b = rand.nextInt(largestPrime - 1);
        return new HashFunction(a, b, largestPrime, tableSize);
    }

    public static HashManager getInstance() {
        if (manager == null) {
            manager = new HashManager();
        }
        return manager;
    }

}
