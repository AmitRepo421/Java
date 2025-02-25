package com.techlabs.controlstructures.assignment;

import java.util.Scanner;

public class PrimePattern {

	private static int nextPrime(int num) {
		num++;
		while (!isPrime(num)) {
			num++;
		}
		return num;
	}

	private static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of lines: ");
		int lines = scanner.nextInt();
		scanner.close();

		int currentPrime = 2;
		for (int i = 1; i <= lines; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(currentPrime + "\t");
				currentPrime = nextPrime(currentPrime);
			}
			System.out.println();
		}
	}
}
