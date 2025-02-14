package com.techlabs.assignments;
import java.text.DecimalFormat;
import java.util.Scanner;
public class CompoundInterest {
	public static double amount;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	public static double interest(double principal, double rate, int time) {
		double interest;
		
		amount = principal*Math.pow(1+(rate/100),time);
		interest = amount-principal;
		
		return interest;
	}
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the principal amount: ");
		double principal = scanner.nextDouble();
		System.out.print("Enter the rate of Interest: ");
		double rate = scanner.nextDouble();
		System.out.print("Enter the time period (In Years): ");
		int time = scanner.nextInt();
		System.out.println("The interest which you would be getting will be " + df.format(CompoundInterest.interest(principal, rate, time))+ " and the total amount you will be getting will be " + df.format(CompoundInterest.amount));
	}
}
