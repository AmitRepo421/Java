package com.techlabs.controlstructures.assignment;

import java.util.Scanner;

public class TreasureHunt {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String choice1, choice2, door;
		System.out.println("Welcome to Treasure Island. Your mission is to find treasure.");
		System.out.println("Choose your way: left or right?");
		choice1 = scanner.next();
		switch (choice1) {
		case "left": {
			System.out.println("Good choice now choose whether you wanna swim or wait?");
			choice2 = scanner.next();
			switch (choice2) {
			case "wait": {
				System.out.println("Good choice again now choose which door you wanna open? Red Blue or Yellow");
				door = scanner.next();
				switch (door) {
				case "red":
					System.out.println("Burned by fire. Game Over.");
					break;
				case "yellow":
					System.out.println("You Win!");
					break;
				case "blue":
					System.out.println("Enten by beasts. Game over.");
					break;
				default:
					System.out.println("Game over.");
				}
				break;
			}
			default:
				System.out.println("Attacked by trout. Game Over.");
				break;
			}
			break;
		}
		default:
			System.out.println("Fallen into a hole. Game Over.");
		}

	}
}
