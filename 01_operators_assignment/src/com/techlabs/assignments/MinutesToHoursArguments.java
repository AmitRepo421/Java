package com.techlabs.assignments;

public class MinutesToHoursArguments {
	public static int minutesToHours(int minutes) {
		int hours = minutes/60;
		int minute = minutes%60;
		System.out.println("The conversion of " + minutes + " minutes into hours is " + hours + " hrs and " + minute + " minutes");
		return hours;
	}
	public static void main(String[]args) {
		int minutes = Integer.parseInt(args[0]);
		MinutesToHoursArguments.minutesToHours(minutes);
	}
}
