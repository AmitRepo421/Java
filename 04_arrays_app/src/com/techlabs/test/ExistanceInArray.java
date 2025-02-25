package com.techlabs.test;
import java.util.*;

public class ExistanceInArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = scanner.nextInt();
		int[] array = new int[size];
		System.out.println("Enter the elements in array");
		for(int i=0;i<size;i++) {
			array[i] = scanner.nextInt();
		}
		System.out.println("Enter the number you wish to check");
		int check = scanner.nextInt();
		for(int i=0;i<size;i++) {
			if(check==array[i]) {
				System.out.println("The element exists in array");
				return;
				
			}
		}System.out.println("The element does not exist in array");
	}
}
