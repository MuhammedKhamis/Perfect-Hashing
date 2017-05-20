package universalHashing.hashFunction;

import universalHashing.interfaces.IHash;

public class HashFunction implements IHash {

    private long a, b, p, tableSize;

    public HashFunction(long a, long b, long p, long tableSize) {
        // TODO Auto-generated constructor stub
        this.a = a;
        this.b = b;
        this.p = p;
        this.tableSize = tableSize;
    }

    @Override
    public int hash(int key) {
        // TODO Auto-generated method stub
        int value = (int) (((a * key + b) % p) % tableSize);
        return value;
    }

}
