package com.techlabs.assignments;
import java.util.Scanner;
public class HourToMinutes {
	public static int minuteToHour(int minutes) {
		int hours = minutes/60;
		int minute = minutes%60;
		System.out.println("The conversion of " + minutes + " minutes into hours is " + hours + " hrs and " + minute + " minutes");
		return hours;
	}
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of minutes you want to convert into hours : ");
		int minutes = scanner.nextInt();
		HourToMinutes.minuteToHour(minutes);
	}
}
