package perfectHashing.pHasher;

import java.util.ArrayList;

import perfectHashing.interfaces.IHasher;
import perfectHashing.util.Pair;
import universalHashing.interfaces.IHash;

public class OneLevelHashing extends IHasher {

    private Pair[] hashMap;

    private IHash hashFunction;

    public OneLevelHashing(int totalSize) {
        super(totalSize);
        // TODO Auto-generated constructor stub
        hashMap = new Pair[totalSize * totalSize];
        hashFunction = manager.getHashFunction(tableSize * tableSize);
    }

    public boolean insert(int key) {
        // TODO Auto-generated method stub
        if (search(key)) {
            return true;
        }
        int index = hashFunction.hash(key);
        if (hashMap[index] == null) {
            // System.out.println("Hashed to " + index);
            hashMap[index] = new Pair(key);
        } else {
            return false;
        }
        return true;

    }

    @Override
    public boolean search(int key) {
        // TODO Auto-generated method stub
        int index = hashFunction.hash(key);
        if (hashMap[index] != null) {
            return hashMap[index].getValue() == key;
        }
        return false;

    }

    @Override
    public int insert(ArrayList<Integer> keys) {
        // TODO Auto-generated method stub
        int collsion = 0;
        boolean err = false;
        for (int i = 0; i < keys.size(); i++) {
            if (!insert(keys.get(i))) {
                collsion++;
                err = true;
                break;
            }
        }
        if (err) {
            hashFunction = manager.getHashFunction(tableSize * tableSize);
            hashMap = new Pair[tableSize * tableSize];
            collsion = collsion + insert(keys);
        }
        return collsion;
    }

}
