package com.techlabs.operators;

public class UnaryOperators {
	public static void main(String[] args) {
		//Need only one operand to perform the operation
		
//		for positive to negative value
		int number = 10;
		System.out.println("The original number is " + number);
		number = -(number);
		System.out.println("The number after using negation is " + number);
//		for boolean values we can use not operator
		boolean answer = true;
		System.out.println("The answer before is : " + answer);
		answer = !(answer);
		System.out.println("The answer now is : " + answer);
		// for incrementing the values
		int numbertrial = 25;
		System.out.println(numbertrial);
		System.out.println(++numbertrial); //increment first hence the value printed will already be incremented
		System.out.println(numbertrial++);//incremented later hence will not be printed with increment here
		System.out.println(numbertrial); // here the incremented number from above step will be printed
		//Decrement works in the same way
		
	}
}
