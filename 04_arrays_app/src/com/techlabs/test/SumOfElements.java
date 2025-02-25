package com.techlabs.test;
import java.util.Scanner;

public class SumOfElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = scanner.nextInt();
		int[] array = new int[size];
		int sum=0;
		System.out.println("Enter the elements in the array");

		for(int i=0;i<size;i++) {
			array[i] = scanner.nextInt();
		
			sum+=array[i];
		}
		System.out.println("The sum of elements in the array is " + sum);
		
	}

}
