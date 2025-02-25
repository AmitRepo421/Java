package com.techlabs.controlstructures.assignment;

import java.util.Scanner;

public class SimpleATMMachine {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		double balance = 1000.00;
		int option;
		
		do{
			System.out.println("ATM Menu:");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Exit");
			System.out.println("Please choose an option: ");
			option = scanner.nextInt();
			
			switch(option) {
			case 1: System.out.println("Your current Balance is: $" + balance );
					break;
			case 2: System.out.print("Enter amount to deposit: ");
					double deposit = scanner.nextDouble();
					balance += deposit;
					System.out.println("You have deposited $" + deposit + ". Your new balance is $" + balance);
					break;
			case 3: System.out.print("Enter amount to withdraw: ");
					double withdraw = scanner.nextDouble();
					if(withdraw<=balance) {
						balance -=withdraw;
						System.out.println("You have withdrawn $" + withdraw + ". Your new balance is $" + balance);
					}else {
						System.out.println("Insufficient balance. Transaction failed!");
					}
					break;
			case 4: System.out.println("Thank you for using the ATM. GoodBye!");
					break;
			default: System.out.println("Invalid input. Please select a correct option.");		
			}
		}while(option!=4);
	}
}
