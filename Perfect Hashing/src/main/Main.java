package main;

import perfect.linear.LinearSolver;
import perfect.quadratic.QuadraticSolver;
import perfect.solver.ISolver;

public class Main {

	public static void main(String[] args) {
		DataReader dataReader = new DataReader();
		int[] keySet = dataReader.getData("tests\\keys10000001000000.txt");
		System.out.println("Size = " + keySet.length);
		ISolver linearSolver = new LinearSolver();
		ISolver quadraticSolver = new QuadraticSolver();
		linearSolver.build(keySet);
		System.out.println("Success Linear");
		quadraticSolver.build(keySet);
		System.out.println("Success Quadratic");
	}
}
