package com.techlabs.assignments;
import java.util.Scanner;
public class BMI1 {

	public static double bmi(double weight, double height) {
		double bmi = weight/(height*height);
		System.out.println("For your weight of " + weight + "Kg and height of " + height + "m your BMI is : " + bmi );
		return bmi;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Body Mass Index Calculator!");
		System.out.print("Enter your weight in KGs : " );
		double weight = scanner.nextDouble();
		System.out.print("Now enter your height in Meters : " );
		double height = scanner.nextDouble();
		if(weight<=0 || height<=0) {
			System.out.println("Please enter valid attributes");
		}else {
			BMI1.bmi(weight, height);
		}
	}
}
