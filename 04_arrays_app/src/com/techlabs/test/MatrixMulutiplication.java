package com.techlabs.test;

import java.util.Scanner;

public class MatrixMulutiplication {
	static Scanner scanner = new Scanner(System.in);

	public static int[][] inputMatrix(int rows, int columns) {

		int[][] matrix = new int[rows][columns];

		System.out.println("Enter array elements");

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		return matrix;
	}

	private static int[][] multiplicationFunction(int matrix1[][], int matrix2[][], int rows, int columns, int rows2, int columns2)
	{
		int[][] mulitplicationMatrix = new int[rows][columns2];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns2; j++) {
				for (int k = 0; k < rows2; k++) {
					mulitplicationMatrix[i][j] = matrix1[i][k] * matrix2[j][k];
					
					System.out.print(mulitplicationMatrix[i][j] + "\t");
					
				}
				
				System.out.println("");
				
			}
		}

		return mulitplicationMatrix;
	}

	public static void main(String[] args) {
		
		System.out.println("For first matrix");
		System.out.println("Enter number of rows");
		int rows = scanner.nextInt();
		
		System.out.println("Enter number of columns");
		int columns = scanner.nextInt();
		
		int matrix1[][] = MatrixMulutiplication.inputMatrix(rows, columns);

		System.out.println("For second matrix");
		System.out.println("Enter number of rows");
		int rows2 = scanner.nextInt();
		
		System.out.println("Enter number of columns");
		int columns2 = scanner.nextInt();
		
		int matrix2[][] = MatrixMulutiplication.inputMatrix(rows2, columns2);

		if (columns != rows2) {
			System.out.println("The dimensions of two matrices do not satisfy the criteria for their mulitplication.");
			return;
		} else {
			System.out.println("The mulitplication of thw two matrices is: ");

			multiplicationFunction(matrix1, matrix2, rows, columns, rows2, columns2);

		}
	}
}
