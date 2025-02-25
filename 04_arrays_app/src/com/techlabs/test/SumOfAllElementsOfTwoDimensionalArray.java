package com.techlabs.test;

import java.util.Scanner;

public class SumOfAllElementsOfTwoDimensionalArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		int sum=0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				sum+=matrix[i][j];
			}
		}
		System.out.println("The sum is " + sum);
	}

}
