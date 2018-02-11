/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserLotteryInputApp;

/**
 *
 * @author CathyLane
 */
import java.util.Random;
import java.util.Scanner;

public class Generator{

	private int[] lottery = new int[6];                    //declaring the 1 day array of size 6.

	public void generateSecretNumbers(){
		int secret;

		for (int i = 0; i < 6; i++) {                  //loop from index 0 so long as index is less than 6 = increment by   1 (fills 6 numbers).
			Random r = new Random();                   //declaring the random class
			secret = r.nextInt(40);                    //secret is the next random number, max number is 40.
			secret = secret +1;                        //ensures secret is not 0 /*

			for (int lot = 0; lot < i; lot++) {        //nested loop
				if (lottery[lot] == secret)            // if the new lottery number is the same as the previous secret....
				{
					secret = r.nextInt(40);
					secret = secret +1;                // another number generated.
					lot = -1;                          // restart the loop
				}

			}
			lottery[i] = secret;                       //lottery number is the next secret number (fills until index 5).
		}

		//System.out.println("The lottery numbers are: ");
		//for (int i = 0; i < lottery.length; i++)        //prints the 6 numbers (length)
		//	System.out.println(lottery[i] + " ");
	}

	public int[] getLottery(){
		return lottery;
	}
}
