package com.techlabs.controlstructures.assignment;

import java.util.Random;
import java.util.Scanner;

public class WordGuesser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "depth", "error", "guard", "doing", "hello", "bye", "forever", "who" };
		String randomWord = words[(int) (Math.random() * words.length)];
		int lives = randomWord.length() * 3;

		char[] blanks = new char[randomWord.length()];
		for (int i = 0; i < blanks.length; i++) {
			blanks[i] = '_';
		}
		Scanner scanner = new Scanner(System.in);
		while (lives > 0) {
			System.out.println("Current word: " + new String(blanks));
			System.out.println("Guess a letter: ");
			char guess = scanner.next().charAt(0);

			boolean found = false;
			for (int i = 0; i < randomWord.length(); i++) {
				if (randomWord.charAt(i) == guess) {
					blanks[i] = guess;
					found = true;
				}
			}
			if (!found) {
				lives--;
				System.out.println("Incorrect guess! Lives remaining: " + lives);
			}
			if (new String(blanks).equals(randomWord)) {
				System.out.println("Congratulations! You won!");
				break;
			}
		}
		if (lives == 0) {
			System.out.println("Game over. The word was: " + randomWord);
		}
	}
}