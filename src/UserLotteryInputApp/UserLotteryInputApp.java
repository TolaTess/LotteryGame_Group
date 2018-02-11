package UserLotteryInputApp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Lottery App Class for lottery game.

@author Omotola Otesanya x17131553
@author Catherine Lane x17118832
@authour Martina Sardo Cardalano x17149676
date 10/12/2017
*/

import java.util.Scanner;
public class UserLotteryInputApp{
	public static void main(String args[]){

		System.out.println("Welcome to our Lottery Game.\nYou can play up to 3 lines per Game with numbers between 1 and 40.\nYou can play as many Games as you wish.\nEnjoy the Game");
		System.out.println(" ");
		Generator random = new Generator();			//create random num generator object
		UserLotteryInput myUserIC; // declare UserLotteryInput instantiable object.
		LotteryGame[] lotteryGames = new LotteryGame[50];
		int gameCounter = 0;
		Scanner choose = new Scanner(System.in);
		String userChoice = "";

		do {
			//declare variables for user's numbers.
			int userNumbers[][]; // 2D arrays for user's inputs.
			int line = 0; // to get the number of lines user wishes to play.

			userNumbers = new int[line][0]; // intialise userNumber to use in UserLotteryInput instantiable class.

			random.generateSecretNumbers();				// call the method to generate random secret numbers
			int [] lottery = random.getLottery();		//store numbers in array

			myUserIC= new UserLotteryInput(); // create  UserLotteryInput object.

			//input to be sent to setter in UserLotteryInput class
			myUserIC.setLines(line);
			myUserIC.setUserNumbers(userNumbers);

			//processing in the UserLotteryInput class
			myUserIC.computeUserLotteryInput();

			//output of 2D array
			int[][] userPick = myUserIC.getUserLines();
			for (int i = 0; i < userPick.length; i++) {
				System.out.println("Lottery Line " + (i+1));
				for (int j = 0; j < userPick[i].length; j++){
					System.out.print(userPick[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println(" ");
			LotteryGame gameEnd = new LotteryGame(lottery,userPick);
			gameEnd.processLinesPlayed();
			gameEnd.displayLineGuessed();

			lotteryGames[gameCounter] = gameEnd;
			gameCounter++;
			System.out.println(" ");
			System.out.println("Would you like to play another game? Type \"y\" if you wish to continue, \"n\" if you want to stop");
			while(choose.hasNext()){
				userChoice = choose.next();
				if(userChoice.equalsIgnoreCase("y")){
					break;
				} else if (userChoice.equalsIgnoreCase("n")){
					History gamesHistory = new History(lotteryGames);
					gamesHistory.display();
					break;
				}else {
					System.out.println("Not a valid answer. Type \"y\" if you wish to continue, \"n\" if you want to stop");
				}
			}
		} while (userChoice.equalsIgnoreCase("y"));
	}
}


