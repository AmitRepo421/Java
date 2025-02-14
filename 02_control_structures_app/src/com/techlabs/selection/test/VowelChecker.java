package com.techlabs.selection.test;

import java.util.Scanner;

public class VowelChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a character ");
		char character;
		character = scanner.next().charAt(0);
		
		switch (character) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':System.out.println("Vowel");
					break;
		default: System.out.println("Not a Vowel");
		}
	}

}
