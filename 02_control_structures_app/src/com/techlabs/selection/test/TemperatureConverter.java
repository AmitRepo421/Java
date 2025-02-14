package com.techlabs.selection.test;
import java.util.*;
public class TemperatureConverter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        

        System.out.println("Enter temperature: ");

        double temperature = scanner.nextDouble();
        double conversion;

        

        System.out.println("Choose conversion:");

        System.out.println("1. Celsius to Fahrenheit");

        System.out.println("2. Fahrenheit to Celsius");

        System.out.println("3. Celsius to Kelvin");

        System.out.println("4. Kelvin to Celsius");

        System.out.println("5. Fahrenheit to Kelvin");

        System.out.println("6. Kelvin to Fahrenheit");

        

        int choice = scanner.nextInt();
        switch (choice) {
        case 1: 
        	conversion = (temperature*9/5)+32;
        	System.out.println(temperature + " °C in °F is " + conversion);
        	break;
        case 2:
        	conversion = (temperature-32)*5/9;
        	System.out.println(temperature + " °F in °C is " + conversion);
        	break;
        case 3:
        	conversion = temperature+273.15;
        	System.out.println(temperature + " °C in K is " + conversion);
        	break;
        case 4:
        	conversion = temperature - 273.15;
        	System.out.println(temperature + " K in °C is " + conversion);
        	break;
        case 5:
        	conversion = (temperature-32)*(5/9)+273.15;
        	System.out.println(temperature + " °F in K is " + conversion);
        	break;
        case 6:
        	conversion = (temperature-273.15)*(9/5)+32;
        	System.out.println(temperature +" K in °F is "+conversion);
        	break;
        default: System.out.println("Please enter a valid input");
        }
        	
	}
}
