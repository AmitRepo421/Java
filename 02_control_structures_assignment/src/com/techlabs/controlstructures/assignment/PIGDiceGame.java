package com.techlabs.controlstructures.assignment;
import java.util.Scanner;
public class PIGDiceGame {
	static int dieRoll(){
		return (int) (6.0 * Math.random()+1);
	}
	public static void main(String[] args) {
		
		int turn=0;
		int totalScore=0;
		int die;
		
			Scanner scanner = new Scanner(System.in);
		
				while(totalScore<20) {
					turn++;
					System.out.println("Turn: " + turn);
				
					int turnScore=0;
					boolean turnOver = false;
					
						while(!turnOver) {
						
							System.out.print("Roll or Hold? (r/h)");
							char input = scanner.next().charAt(0);
							
							if(input=='r') {
								die = PIGDiceGame.dieRoll();
								System.out.println("Die: "+die);
							
								if(die==1) {
									System.out.println("Turn Over. No Score.");
									
									turnScore=0;
									
									turnOver = true;
						
								} else 
									turnScore += die;
							
							} else if(input=='h') {
								turnOver=true;
								
								totalScore+=turnScore;
								
								System.out.println("Score for turn: " + turnScore);
								System.out.println("Total Score: " + totalScore);
							}
							
						}
						
				}
				
				System.out.println("You finished in " + turn + " turns.");
				System.out.println("Game Over!");
			
		}
}

