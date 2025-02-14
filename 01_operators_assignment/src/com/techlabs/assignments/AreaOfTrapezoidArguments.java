package com.techlabs.assignments;

public class AreaOfTrapezoidArguments {
	double area(double base1, double base2, double height) {
		double area = ((base1+base2)/2)*height;
		return area;
	}
	public static void main(String[]args) {
		double base1 = Double.parseDouble(args[0]);
		double base2 = Double.parseDouble(args[1]);
		double height = Double.parseDouble(args[2]);
		AreaOfTrapezoidArguments trapezoid1 = new AreaOfTrapezoidArguments();
		double area = trapezoid1.area(base1, base2, height);
		System.out.println("The area of the trapezoid is: "+area);
	}
}
