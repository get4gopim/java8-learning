package com.example.hackerrank.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author gopinathan.m
INPUT:
2
2
8 5
1 10
6
9 9
3 5
6 6
2 8
2 2
1 3

OUTPUT:
0
55

 */


public class Hacker2 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();

		List<Matrix> points = new ArrayList<>();

		for (int i = 0; i < tests; i++) {
			int n = in.nextInt();

			for (int j = 0; j < n; j++) {
				Matrix m = new Matrix(in.nextInt(), in.nextInt());
				points.add(m);
			}
			
			int count = solveMatrix(points);
			System.out.println(count);
		}

		in.close();
	}

	private static int solveMatrix(List<Matrix> points) {
		int count = 0;
		
		for (int i=0;i<points.size();i++) {
			Matrix point = points.get(i);
			for (int j=i+1;j<points.size();j++) {
				Matrix point1 = points.get(j);
				
				if (Math.abs(point1.getRow() - point.getRow()) == Math.abs(point1.getCol() - point.getCol())) {
					System.out.println(point1 + "  " + point);
					++count;
				}
			}

		}
		
		return count;
	}

}

class Matrix {
	int row;
	int col;

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Matrix(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public Matrix() {

	}

	@Override
	public String toString() {
		return "Input [" + row + ", " + col + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matrix other = (Matrix) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

}
