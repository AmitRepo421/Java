package com.techlabs.test;

import java.util.Scanner;

public class TypeCasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number");
		Scanner scanner = new Scanner(System.in);
		int number = (int) scanner.nextDouble();
		System.out.println(number);
		double number2 = number;
		System.out.println(number2);
		byte a = 10;
		byte b = (byte) (a+10);
		System.out.println(b);
		short c = (short)((a+b)*20);
		System.out.println(c);
		byte d = (byte)c;
		System.out.println(d);
	}

}
