/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserLotteryInputApp;

/*********************************************************************
*LotteryGame instantiable class compares the secret random numbers
*against each line played by the gamer and returns the number guessed
*for each line
*@author Martina Sardo Cardalano
******************************************************************/

public class LotteryGame{

	//provided by main via Generator and UserLotteryInput
	private int [] secretNumbers;
	private int [][] linesPlayed;
	private int [][] guessedNumbers;

	//variables for history
	//stores values for  number of lines played, lines won, total winnings, times the user won the lottery

	private int [] historyElements = new int [4];
	private final int GUESSED3 = 9;
	private final int GUESSED4 = 54;
	private final int GUESSED5 = 1000;


	//constructor

	public LotteryGame(int[] secretNumbers, int[][] linesPlayed){
		this.secretNumbers = secretNumbers;
		this.linesPlayed = linesPlayed;
		historyElements[0] = linesPlayed.length;
	}


	//processing

	public void processLinesPlayed(){							//compare secret and user input
		guessedNumbers = new int[linesPlayed.length][1];
		for (int i = 0; i < linesPlayed.length; i++){
			int guessedCount = 0;
			for (int j = 0; j < linesPlayed[i].length; j++){
				for(int k = 0; k < secretNumbers.length; k++){
					if(secretNumbers[k] == linesPlayed[i][j]){
						guessedCount++;
					}
				}
			}
			guessedNumbers[i][0] = guessedCount;

			if (guessedCount >= 3){						//calculate winnings
				historyElements[1]++;

				switch (guessedCount){
					case 3: historyElements[2] += GUESSED3;
						break;
					case 4: historyElements[2] += GUESSED4;
						break;
					case 5: historyElements[2] += GUESSED5;
						break;
					case 6: historyElements[3]++;
						break;
				}
			}
		}
	}


	public void displayLineGuessed(){
		System.out.println("The secret numbers were: ");  //print secret numbers
		for(int i = 0; i < secretNumbers.length; i++){
			System.out.print(secretNumbers[i] + " ");
		}
		System.out.println();
		String gameResult = "";
		for(int i = 0; i < guessedNumbers.length; i++){
			int line = i+1;
			switch (line){
				case 1: gameResult += "You guessed ";
					break;
				case 2: gameResult +=  ", ";
					break;
				case 3: gameResult += " and ";
					break;
			}
			gameResult += guessedNumbers[i][0] + " number";
			if(guessedNumbers[i][0] != 1){
				gameResult += "s";
			}
			gameResult += " on line "  + line;
		}
		System.out.println(gameResult);
	}


	//getters for History class

	public int getNumberOfLinesPlayed(){
		return historyElements[0];
	}
	public int getLinesWon(){
		return historyElements[1];
	}
	public int getTotalWinnings(){
		return historyElements[2];
	}
	public int getTimesWonTheLottery(){
		return historyElements[3];
	}
}





