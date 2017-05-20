package perfect.quadratic;

import java.util.Arrays;

import perfect.solver.ISolver;
import universal.hashing.IHashFunction;
import universal.hashing.UniversalHashingFamily;

public class QuadraticSolver implements ISolver {
	private int[] hashTable;
	private IHashFunction hashFunction;
	private UniversalHashingFamily universal;
	private final int largestPrime = Integer.MAX_VALUE;

	public QuadraticSolver() {
		universal = new UniversalHashingFamily();
	}

	@Override
	public void build(int[] keySet) {
		int tableSize = (keySet.length) * (keySet.length);
		hashTable = new int[tableSize];

		do {
			hashFunction = universal.getRandomHashFunction(tableSize, largestPrime);
		} while (checkCollision(hashFunction, keySet));
	}

	@Override
	public boolean search(int key) {
		int ind = this.hashFunction.computeHashValue(key);
		return (hashTable[ind] == key);
	}

	private boolean checkCollision(IHashFunction hashFun, int[] keySet) {
		// assume zero is not in allowed value (initial value only)
		Arrays.fill(this.hashTable, -1);

		for (int key : keySet) {
			int ind = hashFun.computeHashValue(key);
			//to handle dublicate keys
			if (hashTable[ind] != -1 && !search(key))
				return true;
			hashTable[ind] = key;
		}
		return false;
	}

	public int[] getHashTable() {
		return hashTable;
	}

	public IHashFunction getHashFunction() {
		return hashFunction;
	}
	
}
