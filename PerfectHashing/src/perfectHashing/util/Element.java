package perfectHashing.util;

import universalHashing.interfaces.IHash;
import universalHashing.universalManager.HashManager;

public class Element {

    private IHash hashFunction;

    private Pair[] hashMap;

    private int size;

    private HashManager manager;

    public Element() {
        // TODO Auto-generated constructor stub
        size = 0;
        hashMap = new Pair[size];
        manager = HashManager.getInstance();
    }

    public void insert(int key) {
        size++;
        Pair[] tmp = new Pair[size * size];
        hashFunction = manager.getHashFunction(size * size);
        for (int i = 0; i < hashMap.length; i++) {
            if (hashMap[i] != null) {
                int index = hashFunction.hash(hashMap[i].getValue());
                tmp[index] = new Pair(hashMap[i].getValue());
            }
        }
        hashMap = tmp;
    }

    public boolean search(int key) {
        int index = hashFunction.hash(key);
        if (hashMap[index] != null) {
            if (hashMap[index].getValue() == key) {
                return true;
            }
        }
        return false;
    }

}
