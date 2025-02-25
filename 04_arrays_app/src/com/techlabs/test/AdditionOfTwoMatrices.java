package com.techlabs.test;

import java.util.Scanner;

public class AdditionOfTwoMatrices {
	static Scanner scanner = new Scanner(System.in);
	public static int[][] inputMatrix(int rows, int columns) {
		
		int[][] matrix = new int[rows][columns];
		
		System.out.println("Enter array elements");
		
		for(int i=0;i<rows;i++) {
			for (int j=0;j<columns;j++) {
				matrix[i][j] = scanner.nextInt();
			}
		} return matrix;
	}
	public static int[][] additionMatrix(int[][] matrix1, int[][]matrix2, int rows, int columns){
		int[][]matrix = new int[rows][columns];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				matrix[i][j] = matrix1[i][j]+matrix2[i][j];
			}
		}
		return matrix;
	}
	public static void main(String[] args) {
		System.out.println("For first matrix");
		System.out.println("Enter number of rows");
		int rows = scanner.nextInt();
		System.out.println("Enter number of columns");
		int columns = scanner.nextInt();
		int matrix1[][] =AdditionOfTwoMatrices.inputMatrix(rows, columns);
		
		System.out.println("For second matrix");
		System.out.println("Enter number of rows");
		int rows2 = scanner.nextInt();
		System.out.println("Enter number of columns");
		int columns2 = scanner.nextInt();
		int matrix2[][] =AdditionOfTwoMatrices.inputMatrix(rows2, columns2);
		
		if(columns!=rows2) {
			System.out.println("Sorry this operation cannot be performed");
			return;
		}else {
			System.out.println("The addition of the matrices is :");
			int additionMatrix[][] = AdditionOfTwoMatrices.additionMatrix(matrix1, matrix2, rows2, columns);
			for(int i=0;i<rows2;i++) {
				for(int j=0;j<columns;j++) {
					System.out.print(additionMatrix[i][j] + "\t");
				}
				System.out.println("");
			}
			
		}
		
	}
}
