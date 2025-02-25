package com.techlabs.test;

import java.util.Scanner;

public class SecondLargestElement {

	static Scanner scanner = new Scanner(System.in);

	private static int[] inputArray(int size) {
		int inputArray[] = new int[size];
		System.out.println("Enter " + size + " elements");
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = scanner.nextInt();
		}
		return inputArray;
	}

	private static void secondLargestElement(int[] numbers) {
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;

		if (numbers.length <= 2) {

			System.out.println("There cannot be second largest number in an array of size " + numbers.length);
			return;

		}
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > largest) {
				secondLargest = largest;
				largest = numbers[i];
			}

		}
		// if(secondLargest !=Integer.MIN_VALUE && secondLargest)
		System.out.println("The second largest element in the array is: " + secondLargest);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter the length of your array: ");
		int size = scanner.nextInt();
		int numbers[] = inputArray(size);

		secondLargestElement(numbers);

	}

}
