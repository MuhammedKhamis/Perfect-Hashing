package perfectHashing.interfaces;

import universalHashing.universalManager.HashManager;

public abstract class IHasher {

    protected int tableSize;

    protected HashManager manager;

    public IHasher(int totalSize) {
        // TODO Auto-generated constructor stub
        this.tableSize = totalSize;
        manager = HashManager.getInstance();
    }

    public abstract int insert(int key);

    public abstract boolean search(int key);

}
