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

    public int insert(int key) {
        if (search(key)) {
            return 0;
        }
        keys.add(key);
        hashMap = new OneLevelHashing(keys.size());
        int collsions = 0;
        for (int i = 0; i < keys.size(); i++) {
            collsions += hashMap.insert(keys.get(i));
        }
        return collsions;

    }

    public boolean search(int key) {
        return hashMap.search(key);
    }

}
