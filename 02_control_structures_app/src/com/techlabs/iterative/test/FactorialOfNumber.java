package com.techlabs.iterative.test;

import java.util.Scanner;

public class FactorialOfNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number= scanner.nextInt();
		int factorial=0;
		for(int i=1;i<=number;i++) {
			factorial=factorial*i;
		}
		System.out.println(factorial);
	}
}
