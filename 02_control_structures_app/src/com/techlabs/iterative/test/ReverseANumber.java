package com.techlabs.iterative.test;
import java.util.Scanner;
public class ReverseANumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number=scanner.nextInt();
		int number2=number;
		boolean palindrome=true;
		int reverse=0;
		while(number>0) {
			
			int temp = number%10;
			reverse = reverse*10+temp;
			number/=10;
			
		}
		if(reverse==number2) {
			System.out.println("The number is a palindrome");
		}else System.out.println("The number is not a palindrome");
		
	}
}
