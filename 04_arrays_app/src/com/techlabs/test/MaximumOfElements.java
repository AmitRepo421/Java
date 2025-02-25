package com.techlabs.test;

import java.util.Scanner;

public class MaximumOfElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int size = scanner.nextInt();
		int[] array = new int[size];
		System.out.println("Enter the elements in the array");
		for(int i=0;i<size;i++) {
			array[i] = scanner.nextInt();
		}
		int maximum = array[0];
		for(int i =0;i<size;i++) {
			if(maximum<array[i]) {
				maximum=array[i];
			}
		}
		System.out.println(maximum);
 		
		
		
	}

}
