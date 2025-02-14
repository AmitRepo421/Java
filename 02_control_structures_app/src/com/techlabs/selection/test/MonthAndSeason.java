package com.techlabs.selection.test;

import java.util.Scanner;

public class MonthAndSeason {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the Month's number : ");
	int month = scanner.nextInt();
	
		switch(month) {
		case 2:
		case 3:
		case 4:
		case 5: System.out.println("It is summer season");
				break;
		case 6:
		case 7:
		case 8:
		case 9: System.out.println("It is rainy season");
				break;
		case 10:
		case 11:
		case 12:
		case 1: System.out.println("It is winter season");
				break;
				
		default: System.out.println("Please enter valid month number");
		
		}
}
}
