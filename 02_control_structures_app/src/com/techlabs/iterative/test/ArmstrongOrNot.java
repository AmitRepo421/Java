package com.techlabs.iterative.test;
import java.util.Scanner;
public class ArmstrongOrNot {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		int sum=0;
		int number2=number;
		int pow=0;
		while(number>0) {
			pow++;
			number/=10;
		}
		number = number2;
		while(number>0) {
			int temp;
			temp=number%10;
			
			int cube=(int) Math.pow(temp, pow);
			
			sum+=cube;
		
			number/=10;
		}
		if(number2==sum) {
			System.out.println("The number is an Armstrong number");
		}else {
			System.out.println("The number is not an Armstrong number");
		}
	}
}
