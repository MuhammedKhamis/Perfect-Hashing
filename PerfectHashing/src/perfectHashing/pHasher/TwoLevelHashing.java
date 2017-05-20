package perfectHashing.pHasher;

import java.util.ArrayList;

import perfectHashing.interfaces.IHasher;
import perfectHashing.util.Element;
import universalHashing.interfaces.IHash;

public class TwoLevelHashing extends IHasher {

    private Element[] hashMap;

    private IHash hashFunction;

    public TwoLevelHashing(int totalSize) {
        super(totalSize);
        // TODO Auto-generated constructor stub
        hashMap = new Element[totalSize];
        hashFunction = manager.getHashFunction(tableSize);

    }

    private boolean insert(int key) {
        int index = hashFunction.hash(key);
        if (hashMap[index] == null) {
            hashMap[index] = new Element();
        }
        return hashMap[index].insert(key);
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

    @Override
    public int insert(ArrayList<Integer> keys) {
        // TODO Auto-generated method stub
        int collsion = 0;
        for (int i = 0; i < keys.size(); i++) {
            if (insert(keys.get(i))) {
                collsion++;
            }
        }
        return collsion;
    }

}
