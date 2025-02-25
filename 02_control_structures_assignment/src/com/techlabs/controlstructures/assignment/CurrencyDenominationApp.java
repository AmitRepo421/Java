package com.techlabs.controlstructures.assignment;

import java.util.Scanner;

public class CurrencyDenominationApp {
	public static void denomination(int amount) {
		int numberOfTwoThousand = 0;
		int numberOfFiveHundred = 0;
		int numberOfTwoHundred = 0;
		int numberOfOneHundred = 0;

		numberOfTwoThousand = (amount / 2000);
		amount = amount % 2000;

		numberOfFiveHundred = (amount / 500);
		amount = amount % 500;

		numberOfTwoHundred = (amount / 200);
		amount = amount % 200;

		numberOfOneHundred = (amount / 100);

		System.out.println("For withdrawing the sum of Rs. " + amount + " you will be receiving :");
		if (numberOfTwoThousand != 0)
			System.out.println("Two Thousand : " + numberOfTwoThousand);
		if (numberOfFiveHundred != 0)
			System.out.println("Five Hundred : " + numberOfFiveHundred);
		if (numberOfTwoHundred != 0)
			System.out.println("Two Hundred : " + numberOfTwoHundred);
		if (numberOfOneHundred != 0)
			System.out.println("One Hundred : " + numberOfOneHundred);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to Currency Denomination App!");
		System.out
				.print("Please enter the amount you wish to withdraw (Maximum amount per transaction is Rs.50,000) : ");

		int amount = scanner.nextInt();

		System.out.println("The currencies denominations available at the moment are Rs.2000, Rs.500, Rs.200, Rs.100");

		if (amount % 100 != 0) {
			System.out.println("The amount should be in multiples of 100.");
		} else if (amount > 50000) {
			System.out.println("The amount exceeds withdrawal limit of Rs. 50000");

		} else {
			CurrencyDenominationApp.denomination(amount);
		}
	}

}
