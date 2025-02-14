package com.techlabs.assignments;

import java.text.DecimalFormat;

public class DistanceBetweenTwoPointsArguments {
	private static final DecimalFormat df = new DecimalFormat("0.00");
	public static double distance(double x1, double y1, double x2, double y2) {
		double distance;
		distance = Math.sqrt((Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2)));
		return distance;		
	}
	public static void main(String[]args) {
		double x1 = Double.parseDouble(args[0]);
		double y1 = Double.parseDouble(args[1]);
		double x2 = Double.parseDouble(args[2]);
		double y2 = Double.parseDouble(args[3]);
		System.out.println("The distance between the two points ("+ x1+ ","+y1+") and ("+x2+","+y2+") is " + df.format(DistanceBetweenTwoPointsArguments.distance(x1, y1, x2, y2)));
	}
}
