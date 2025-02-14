package com.techlabs.iterative.test;

import java.util.Scanner;

public class PerfectNumber {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int number = scanner.nextInt();
		int divisor =1;
		int sum=0;
		while(divisor <=number/2) {
			
			if(number%divisor==0) {
				sum+=divisor;
			}
			divisor++;
		}
		if(sum==number) {
			System.out.println("The number is a perfect number");
		}else System.out.println("The number is not a perfect number");
	}
}
