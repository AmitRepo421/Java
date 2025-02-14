package com.techlabs.iterative.test;

public class OddNumberPrinter {
	public static void main(String[] args) {
		int number = 1;
		while(number<=100) {
			if(number%2!=0) {
			System.out.println( number +" is a odd number");
			}
			number++;
		}
	}
}
