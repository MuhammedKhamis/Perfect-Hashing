package universalHashing.hashFunction;

import universalHashing.interfaces.IHash;

public class HashFunction implements IHash {

    private int a, b, p, tableSize;

    public HashFunction(int a, int b, int p, int tableSize) {
        // TODO Auto-generated constructor stub
        this.a = a;
        this.b = b;
        this.p = p;
        this.tableSize = tableSize;
    }

    @Override
    public int hash(int key) {
        // TODO Auto-generated method stub
        int value = ((a * key + b) % p) % tableSize;
        return value;
    }

}
