package com.techlabs.iterative.test;
import java.util.*;
public class SumOfDigitsOfNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		int sum=0;
		
		while(number>0) {
			int temp;
			temp=number%10;
			sum+=temp;
			number/=10;
		}
		System.out.println(sum);
	}
}
