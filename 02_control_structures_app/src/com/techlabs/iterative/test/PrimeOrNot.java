package com.techlabs.iterative.test;

import java.util.Scanner;

public class PrimeOrNot {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i = 2;
		int sum=0;
		int number = scanner.nextInt();
		while (i < number) {
			if (number % i == 0) {
				sum +=i;
			}
			i++;
		}
		if(sum==0) {
			System.out.println("The number is a prime number");
			
		}else System.out.println("The number is not a prime");
	}
}
