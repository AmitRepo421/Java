package com.techlabs.assignments;
import java.text.DecimalFormat;
import java.util.Scanner;
public class DistanceBetweenTwoPoints {
	private static final DecimalFormat df = new DecimalFormat("0.00");
	public static double distance(double x1, double y1, double x2, double y2) {
		double distance;
		distance = Math.sqrt((Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2)));
		
		return distance;
	}
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the X co-ordinate of first point: ");
		double x1 = scanner.nextDouble();
		System.out.print("Now enter the Y co-ordinate of first point: ");
		double y1 = scanner.nextDouble();
		System.out.print("Enter the X co-ordinate of second point: ");
		double x2 = scanner.nextDouble();
		System.out.print("Enter the Y co-ordinate of second point: ");
		double y2 = scanner.nextDouble();
		System.out.println("The distance between the two points ("+x1+","+y1+") and ("+x2+","+y2+") is " + df.format(DistanceBetweenTwoPoints.distance(x1, y1, x2, y2)));
	}
}
