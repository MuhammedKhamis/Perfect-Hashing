package perfectHashing.pHasher;

import java.util.ArrayList;

import perfectHashing.interfaces.IHasher;
import perfectHashing.util.Pair;
import universalHashing.interfaces.IHash;

public class OneLevelHashing extends IHasher {

    private Pair[] hashMap;

    private ArrayList<IHash> hashers;

    public OneLevelHashing(int totalSize) {
        super(totalSize);
        // TODO Auto-generated constructor stub
        hashMap = new Pair[totalSize * totalSize];
        hashers = new ArrayList<IHash>();
        hashers.add(manager.getHashFunction(tableSize * tableSize));
    }

    @Override
    public int insert(int key) {
        // TODO Auto-generated method stub
        int collsions = 0;
        boolean added = false;
        for (int j = 0; j < hashers.size(); j++) {
            int index = hashers.get(j).hash(key);
            if (hashMap[index] == null) {
                hashMap[index] = new Pair(key);
                added = true;
                break;
            } else if (hashMap[index].getValue() == key) {
                added = true;
                break;
            }
        }
        if (!added) {
            collsions++;
            hashers.add(manager.getHashFunction(tableSize * tableSize));
            collsions += insert(key);
        }

        return collsions;

    }

    @Override
    public boolean search(int key) {
        // TODO Auto-generated method stub
        if (hashers.size() == 0) {
            return false;
        }
        for (int i = 0; i < hashers.size(); i++) {
            int index = hashers.get(i).hash(key);
            if (hashMap[index] != null) {
                if (hashMap[index].getValue() == key)
                    return true;
            }
        }
        return false;

    }

}
