package com.techlabs.operators;

public class LogicalOperators {
	public static void main(String[] args) {
		int number1 = 20;
		int number2 = 40;
		if(number1<=number2 && number2<(number1*2)) {
			System.out.println("As both conditions are true this will get executed");
			
		}
		else if(number1<=number2 || number2>(number1*2)) {
			System.out.println("Even though condition 2 is false it will still be executed");
		}
		//The logical not operator will reverse the actual answer
		System.out.println("The number 2 is greater than number 1 this is " + (number2>number1) + " but the logical not will convert it to " + !(number2>number1));
	}
}
