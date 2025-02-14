package com.techlabs.assignments;

import java.util.Scanner;

public class AreaOfTrapezoid {
	public static double area(double base1, double base2, double height) {
		double area;
		area = ((base1+base2)/2)*height;
		return area;
	}
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to calculation of Area of Trapezoid ");
		System.out.print("Enter the length of first base: ");
		double base1 = scanner.nextDouble();
		System.out.print("Enter the length of second base: ");
		double base2 = scanner.nextDouble();
		System.out.print("Enter the height of Trapezoid: ");
		double height = scanner.nextDouble();
		AreaOfTrapezoid first = new AreaOfTrapezoid();
		double finalarea = first.area(base1, base2, height);
		System.out.println("The area of trapezoid is : " + finalarea);
		
	}
}
