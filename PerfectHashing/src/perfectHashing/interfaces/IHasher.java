package perfectHashing.interfaces;

import java.util.ArrayList;

import universalHashing.universalManager.HashManager;

public abstract class IHasher {

    protected int tableSize;

    protected HashManager manager;

    public IHasher(int totalSize) {
        // TODO Auto-generated constructor stub
        this.tableSize = totalSize;
        manager = HashManager.getInstance();
    }

    public abstract int insert(ArrayList<Integer> keys);

    public abstract boolean search(int key);

}
