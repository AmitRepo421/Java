package com.techlabs.operators;

public class AssignmentOperator {
	public static void main(String[] args) {
		//Assignment operators are used to assign values
		int number1=10;
		int number2;
		number2=number1;
		System.out.println(number2);
		//Increment and assignment
		number2 +=number1;
		System.out.println(number2);
		//Decrement and assignment
		number2 -=number1;
		System.out.println(number2);
		//Multiply and assign
		number2 *= number1;
		System.out.println(number2);
		//Divide and assign
		number2 /= number1;
		System.out.println(number2);
		//Modulus and assign
		number2 %= number1;
		System.out.println(number2);
	}
}
