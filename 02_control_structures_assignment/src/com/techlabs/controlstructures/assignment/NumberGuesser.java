package com.techlabs.controlstructures.assignment;

import java.util.Scanner;

public class NumberGuesser {
	static int finalRandom;
	static int numberOfAttempts = 1;
	static int input;
	static Scanner scanner = new Scanner(System.in);

	public static int randomNumberGenerator() {
		double randomNumber = Math.random();
		double finalRandomNumber = randomNumber * 100;
		finalRandom = (int) finalRandomNumber;

		return finalRandom;
	}

	public static void game() {
		NumberGuesser.randomNumberGenerator();

		System.out.println("Welcome to Random Number Guesser!");
		System.out.println("\n");
		System.out.println("Make a guess of the number, the number is between 1 to 100");
		String answer;
		input = scanner.nextInt();

		while (input != finalRandom) {
			if (input < finalRandom) {
				System.out.println("Sorry, Too Low");
				System.out.println("Do you want to make a guess again?");
				answer = scanner.next();
				switch (answer) {
				case "yes": {
					System.out.println("Okay make a guess again");
					input = scanner.nextInt();
					numberOfAttempts++;
					break;
				}
				case "no": {
					System.out.println("Thank you for playing you tried " + numberOfAttempts + " times!");
					return;
				}
				default: {
					System.out.println("Please enter a valid input");
				}
				}

			} else if (input > finalRandom) {
				System.out.println("Sorry, Too High");
				System.out.println("Do you want to make a guess again?");
				answer = scanner.next();
				switch (answer) {
				case "yes": {
					System.out.println("Okay make a guess again");
					input = scanner.nextInt();
					numberOfAttempts++;
					break;
				}
				case "no": {
					System.out.println("Thank you for playing you tried " + numberOfAttempts + " times!");
					break;

				}
				default: {
					System.out.println("Please enter a valid input");
				}
					return;
				}

			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NumberGuesser.game();
		if (input == finalRandom) {
			System.out.println(
					"Congratulations you have correctly guessed the number in " + numberOfAttempts + " attempts");
			System.out.println("Do you wish to play again?");
			System.out.println();
			String option = scanner.next();
			switch (option) {
			case "yes":
				numberOfAttempts = 1;
				NumberGuesser.game();
				break;
			case "no":
				System.out.println("Thank you for playing!");
			}

		}

	}

}
