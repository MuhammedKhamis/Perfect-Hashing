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
    }

    @Override
    public int insert(ArrayList<Integer> keys) {
        // TODO Auto-generated method stub
        int collsions = 0;
        hashFunction = manager.getHashFunction(tableSize);
        for (int i = 0; i < keys.size(); i++) {
            int index = hashFunction.hash(keys.get(i));
            if (hashMap[index] == null) {
                hashMap[index] = new Element();
            } else {
                collsions++;
            }
            hashMap[index].insert(keys.get(i));
        }
        return collsions;
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

}
