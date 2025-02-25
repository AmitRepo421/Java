package com.techlabs.test;

import java.util.Scanner;

public class MaxInTwoDimensionalArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter how many rows:");
		int rows = scanner.nextInt();
		System.out.println("Enter how many columns:");
		int columns = scanner.nextInt();
		
		int[][] matrix = new int[rows][columns];
		
		System.out.println("Enter array elements");
		
		for(int i=0;i<rows;i++) {
			for (int j=0;j<columns;j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		int max = 0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				if(max<matrix[i][j])
					max=matrix[i][j];
			}
		}
		System.out.println(max);
	}
}
