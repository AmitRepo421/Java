package com.techlabs.operators;
import java.util.Scanner;
public class ArithmaticOperators {
	public static int add(int number1, int number2) {
		int addition = number1 + number2;
		System.out.println("The addition of the two numbers "+ number1 + " and "+ number2 + " is " + addition);
		return addition;
		
	}
	public static int subtract(int number1, int number2) {
		int subtraction = number1 - number2;
		System.out.println("The subtraction of the two numbers " + number1 + " and " + number2 + " is " + subtraction);
		return subtraction;
	}
	public static int multiply(int number1, int number2) {
		int multiplication= number1*number2;
		System.out.println("The multiplication of the two numbers " + number1 + " and " + number2 + " is " + multiplication);
		return multiplication;
	}
	public static int divide(int number1, int number2) {
		int division = number1/number2;
		System.out.println("The division of the two numbers " + number1 + " and " + number2 + " is " + division);
		return division;
	}
	public static int modulus(int number1, int number2) {
		int modulus = number1%number2;
		System.out.println("The remainder after division of two numbers is " + modulus);
		return modulus;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the first Number : ");
		int number1 = scanner.nextInt();
		System.out.print("Enter the second Number : " );
		int number2 = scanner.nextInt();
		System.out.println("Enter the operation you would like to perform : 1. addition 2. subtraction 3. multiplication 4. division 5. modulus ");
		int operation = scanner.nextInt();
		switch (operation) {
		case (1):
			ArithmaticOperators.add(number1, number2);
		break;
		case (2):
			ArithmaticOperators.subtract(number1, number2);
		break;
		case (3):
			ArithmaticOperators.multiply(number1, number2);
		break;
		case (4):
			ArithmaticOperators.divide(number1, number2);
		break;
		case (5):
			ArithmaticOperators.modulus(number1, number2);
		break;
		}
	}
}
