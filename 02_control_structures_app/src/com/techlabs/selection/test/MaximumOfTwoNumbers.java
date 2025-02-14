package com.techlabs.selection.test;

import java.util.Scanner;

public class MaximumOfTwoNumbers {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the first number: ");
		int number1=scanner.nextInt();
		System.out.print("Enter the second number: ");
		int number2=scanner.nextInt();
		if(number1>number2) {
			System.out.print("The number " + number1 + " is greater");
		}else if(number2>number1) {
			System.out.print("The number " + number2+ " is greater");
		}else {
			System.out.println("Both numbers are same");
		}

	}

}
