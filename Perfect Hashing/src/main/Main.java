package main;

import java.util.HashSet;
import java.util.Random;

import perfect.linear.LinearSolver;
import perfect.quadratic.QuadraticSolver;
import perfect.solver.ISolver;

public class Main {

	public static void main(String[] args) {
		DataReader dataReader = new DataReader();
		int[] keySet = dataReader.getData("tests\\keys1001000.txt");
		System.out.println("Size = " + keySet.length);
		ISolver linearSolver = new LinearSolver();
		ISolver quadraticSolver = new QuadraticSolver();
		linearSolver.build(keySet);
		System.out.println("Success Linear");
		quadraticSolver.build(keySet);
		System.out.println("Success Quadratic");

		checkSearch(keySet, linearSolver);
		checkSearch(keySet, quadraticSolver);
	}

	public static boolean checkSearch(int[] keySet, ISolver solver) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int key : keySet) {
			set.add(key);
		}

		Random random = new Random();
		for (int i = 0; i < 1000; i++) {
			int key = random.nextInt(100000);
			// System.out.println(i);
			if (set.contains(key) != solver.search(key)) {
				System.out.println("error");
			}
		}

		for (int i = 0; i < keySet.length; i++) {
			if (set.contains(keySet[i]) != solver.search(keySet[i])) {
				System.out.println("error");
			}
		}
		System.out.println("success searching");
		return true;
	}
}