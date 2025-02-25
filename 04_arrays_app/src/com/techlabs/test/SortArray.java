package com.techlabs.test;

import java.util.Scanner;

public class SortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = scanner.nextInt();
		int[] array = new int[size];
		System.out.println("Enter the elements in array");
		for(int i=0;i<size;i++) {
			array[i] = scanner.nextInt();
		}
		
		for(int i=0;i<size;i++) {
			for(int j=i+1;j<size;j++) {
				if(array[i]>array[j]) {
					int temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		for(int i=0;i<size;i++) {
			System.out.println(array[i]);
		}
	}

}
