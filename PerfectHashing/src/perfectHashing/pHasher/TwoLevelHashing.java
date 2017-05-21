package perfectHashing.pHasher;

import java.util.ArrayList;

import perfectHashing.interfaces.IHasher;
import universalHashing.interfaces.IHash;

public class TwoLevelHashing extends IHasher {

    private OneLevelHashing[] hashMap;

    private IHash hashFunction;

    private static final int factor = 7;

    private int[] tester;

    public TwoLevelHashing(int totalSize) {
        super(totalSize);
        // TODO Auto-generated constructor stub
        hashMap = new OneLevelHashing[totalSize];
        hashFunction = manager.getHashFunction(tableSize);

    }

    @Override
    public boolean search(int key) {
        // TODO Auto-generated method stub
        int index = hashFunction.hash(key);
        if (hashMap[index] != null) {
            return hashMap[index].search(key);
        }
        return false;
    }

    private boolean chooseOfHash(ArrayList<Integer> keys) {
        tester = new int[tableSize];
        for (int i = 0; i < tableSize; i++) {
            int index = hashFunction.hash(keys.get(i));
            tester[index]++;
        }
        int size = 0;
        for (int i = 0; i < tableSize; i++) {
            size += (tester[i] * tester[i]);
            if (size > tableSize * factor) {
                // return true;
            }
        }
        System.out.println("Total : " + size);
        return false;
    }

    @Override
    public int insert(ArrayList<Integer> keys) {
        // TODO Auto-generated method stub
        while (chooseOfHash(keys)) {
            hashFunction = manager.getHashFunction(tableSize);
        }

        int collsions = 0;
        ArrayList<ArrayList<Integer>> tmp = new ArrayList<>();
        for (int i = 0; i < tableSize; i++) {
            tmp.add(new ArrayList<>());
        }
        for (int i = 0; i < keys.size(); i++) {
            int index = hashFunction.hash(keys.get(i));
            tmp.get(index).add(keys.get(i));
        }
        for (int i = 0; i < tableSize; i++) {
            hashMap[i] = new OneLevelHashing(tmp.get(i).size());
            int val = hashMap[i].insert(tmp.get(i));
            if(val > 6){
                  //System.out.println("More than Expected");
            }
            collsions += val;  
            
        }
        return collsions;
    }

}
