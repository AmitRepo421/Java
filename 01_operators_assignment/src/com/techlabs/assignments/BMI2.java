package com.techlabs.assignments;

public class BMI2 {
	public static double bmi(double weight, double height) {
		double bmi = weight/(height*height);
		System.out.println("For your weight of " + weight + "Kg and height of " + height + "m your BMI is : " + bmi );
		return bmi;
	}
	public static void main(String[] args) {
		
		System.out.println("Welcome to Body Mass Index Calculator!");
		System.out.print("Enter your weight in KGs : " );
		double weight = Double.parseDouble(args[0]);
		System.out.print("Now enter your height in Meters : " );
		double height = Double.parseDouble(args[1]);
		if(weight<=0 || height<=0) {
			System.out.println("Please enter valid attributes");
		}else {
			BMI2.bmi(weight, height);
		}
	}
}

