package com.techlabs.test;

import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of array which you want to create");
		int size = scanner.nextInt();
		int array[] = new int[size];
		System.out.println("Enter digits of array");
		for(int i=0;i<size;i++) {
			array[i] = scanner.nextInt();
		}
		for(int i=0;i<size;i++) {
			System.out.print(array[i] + "\t");
		}
	}

}
