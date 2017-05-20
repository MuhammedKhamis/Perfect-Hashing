package perfectHashing.util;

import java.util.ArrayList;

import perfectHashing.pHasher.OneLevelHashing;

public class Element {

    private OneLevelHashing hashMap;

    private ArrayList<Integer> keys;

    public Element() {
        // TODO Auto-generated constructor stub
        hashMap = new OneLevelHashing(1);
        keys = new ArrayList<>();
    }

    public boolean insert(int key) {
        if (search(key)) {
            return false;
        }
        keys.add(key);
        hashMap = new OneLevelHashing(keys.size());
        return hashMap.insert(keys) > 0;

    }

    public boolean search(int key) {
        return hashMap.search(key);
    }

}
