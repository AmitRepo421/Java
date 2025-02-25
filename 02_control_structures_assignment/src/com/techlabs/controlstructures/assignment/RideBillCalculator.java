package com.techlabs.controlstructures.assignment;

import java.util.Scanner;

public class RideBillCalculator {
	public static void main(String[] args) {
		int age;
		int bill = 0;
		String photos;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your height in cm ");
			int Height = scanner.nextInt();
		if(Height<120) {
			System.out.println("Sorry you can not ride.");
		}else {
			System.out.println("You can ride.");
			System.out.println("Please enter your age.");
			age = scanner.nextInt();
				
				if(age<12) {
					bill+=5;
					
				}else if(age<18&&age>=12) {
					bill+=7;
				}else if(age>=18&&age<45) {
					bill+=12;
				}else {
					bill=0;
				}
		System.out.println("Do you want photos?");
		photos =scanner.next();
		switch(photos) {
		case "yes":
			bill+=3;
			System.out.println("The total bill is $" +bill);
			break;
		case "no":
			System.out.println("The total bill is $"+bill);
		}
		
			
		}
	}
}
