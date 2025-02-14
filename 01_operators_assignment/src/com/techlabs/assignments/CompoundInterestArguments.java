package com.techlabs.assignments;
import java.text.DecimalFormat;
import java.util.*;
public class CompoundInterestArguments {
	private static DecimalFormat df = new DecimalFormat("0.00");
	public static double amount;

	public static double interest(double principal, double rate, double time) {
		amount = principal*Math.pow((1+(rate/100)), time);
		double interest = amount-principal;
		return interest;
	}
	public static void main(String[]args) {
		System.out.println("Welcome to Compound Interest Calculator ");
		double principal = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		double time = Double.parseDouble(args[2]);
		System.out.println("For the amount of Rs." +principal+" at an interest rate of "+rate+"% for a time period of "+time+" years you will get an interest of Rs. "+ df.format(CompoundInterestArguments.interest(principal, rate, time))+" and the total amount will be Rs. " + df.format(amount));
	}
}
