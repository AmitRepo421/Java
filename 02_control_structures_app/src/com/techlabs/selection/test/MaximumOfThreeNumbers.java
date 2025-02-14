package com.techlabs.selection.test;

import java.util.Scanner;

public class MaximumOfThreeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the first number : ");
		int number1 = scanner.nextInt();
		System.out.println("Enter the second number : ");
		int number2 = scanner.nextInt();
		System.out.println("Enter the third number : ");
		int number3 = scanner.nextInt();
		if((number1>number2)&&(number1>number3)) {
			System.out.println("The number " + number1 + " is greatest");
		}else if((number2>number1)&&(number2>number3)) {
			System.out.println("The number " + number2 + " is greatest");
		}else {
			System.out.println("The number " + number3+ " is greatest");
		}
	}

}
