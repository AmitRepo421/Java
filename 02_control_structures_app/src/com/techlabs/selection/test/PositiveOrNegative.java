package com.techlabs.selection.test;

import java.util.Scanner;

public class PositiveOrNegative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number you wish to check");
		int number = scanner.nextInt();
		if(number>0) {
			System.out.println("The number " + number + " is a positive number");
		}else if(number<0){
			System.out.println("The number " + number + " is a negative number");
		}else {
			System.out.println("The number 0 is neither positive nor negative");
			
		}
	}

}
