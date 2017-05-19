package perfectHashing.pHasher;

import perfectHashing.interfaces.IHasher;
import perfectHashing.util.Pair;

public class OneLevelHashing extends IHasher {

    private Pair[] hashMap;

    public OneLevelHashing(int totalSize) {
        super(totalSize);
        // TODO Auto-generated constructor stub
        hashMap = new Pair[totalSize * totalSize];
    }

    @Override
    public int insert() {
        // TODO Auto-generated method stub
        int collsions = 0;
        hashers.add(manager.getHashFunction(tableSize));
        boolean added = false;
        for (int i = 0; i < keys.size(); i++) {
            added = false;
            for (int j = 0; j < hashers.size(); j++) {
                int index = hashers.get(j).hash(keys.get(i));
                if (!hashMap[index].isOccupied()) {
                    hashMap[index].setValue(keys.get(i));
                    added = true;
                    break;
                }
            }
            if (!added) {
                collsions++;
                hashers.add(manager.getHashFunction(tableSize));
                i--;
            }
        }
        return collsions;

    }

    @Override
    public boolean search(int key) {
        // TODO Auto-generated method stub
        for (int i = 0; i < hashers.size(); i++) {
            int index = hashers.get(i).hash(key);
            if (hashMap[index].isOccupied()) {
                if (hashMap[index].getValue() == key)
                    return true;
            }
        }
        return false;

    }

}
