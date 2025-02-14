package com.techlabs.selection.test;

import java.util.Scanner;

public class WaterBillCalculator {

	public static void main(String[] args) {
		int Meter_charge = 75;
		int charge = 0;
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Water Bill Calculator");
		System.out.print("Enter the number of units consumed: ");
		int units = scanner.nextInt();
		if(units<=100) {
			charge=units*5;
		}
		else if(100<units&&units<250) {
				charge=(units-100)*10+100*5;
			}
		else {
			if(units<=250) {
				charge=units*10;
			}else if(units>=250){
				charge = 100*5+(units-150-100)*10+(units-250)*20;
			}
		
		int total_water_bill = charge+Meter_charge;
		System.out.println("The total Water bill will be Rs. "+total_water_bill);
		scanner.close();
		}
	}
}
