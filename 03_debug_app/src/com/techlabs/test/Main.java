package com.techlabs.test;

import java.util.Scanner;

public class Main {
	private static int addition(int number1, int number2) {
		return number1+number2;
	}
	
	public static int subtraction(int number1, int number2) {
		return number1-number2;
	}
	
	public static int multiplication(int number1, int number2) {
		return number1*number2;
	}
	
	public static int divison(int number1, int number2) {
		return number1/number2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter two numbers");
		
		int number1 = scanner.nextInt();
		int number2 = scanner.nextInt();
		
		int result=addition(number1, number2);
		int result2=subtraction(number1, number2);
		int result3=multiplication(number1, number2);
		int result4=divison(number1, number2);
		
		System.out.println("Addition = " + result);
		System.out.println("Subtraction =" + result2);
		System.out.println("Multiplication = " + result3);
		System.out.println("Divison = " + result4);
	}

}
