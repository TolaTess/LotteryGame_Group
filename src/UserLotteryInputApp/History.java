/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserLotteryInputApp;

/**
 *
 * @author Martina Cardalano
 */
public class History{

	private LotteryGame[] lotteryGames;

	public History(LotteryGame[] lotteryGames){
		this.lotteryGames = lotteryGames;
	}

	public void display(){
		System.out.println();
		System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*");
		System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+HISTORY*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+");
		System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*");
		for(int i = 0; i < lotteryGames.length; i++){
			if(lotteryGames[i] != null){
				System.out.println("Number of lines played: " + lotteryGames[i].getNumberOfLinesPlayed());
				System.out.println("Number of lines won: " + lotteryGames[i].getLinesWon());
				System.out.println("Total winnings: " + lotteryGames[i].getTotalWinnings());
				System.out.println("Number of times you won the lottery: " + lotteryGames[i].getTimesWonTheLottery());
			}
		}
		System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*");
	}
}
