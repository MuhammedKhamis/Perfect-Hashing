package perfectHashing.pHasher;

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

    @Override
    public int insert(int key) {
        // TODO Auto-generated method stub
        int collsions = 0;
        int index = hashFunction.hash(key);
        if (hashMap[index] == null) {
            hashMap[index] = new Element();
        }
        collsions = hashMap[index].insert(key);
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
