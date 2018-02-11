/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserLotteryInputApp;

/*
Instantiable Class to accept user numbers using 2D arrays for Lottery Game (Software Development PBL project)
- up to 3 lines per game;
- accept six numbers between 1 and 40;
- only accept unique numbers per line;
- display lines played and store numbers for comparasion with winning lottery numbers;
@author Omotola Otesanya x17131553.
date 10/12/2017
*/

import java.util.Scanner; // import Scanner class to accept user's input through Scanner Object.
public class UserLotteryInput{ // UserLotteryInput Class starts
	
	//declare data members
	private int[][] userNumbers;  //  2D array to accept users lottery numbers
	private final int low = 1;  // lowest number that can be entered by user
	private final int high = 40;  // highest number that can be entered by user
	private final int numbersPerLine = 6;  // number per line
	private int lines; // number of lottery lines user wishes to play
	private int[] userLines; // users line for output and comparasion

	Scanner in = new Scanner(System.in); // declaring and creating Scanner Object
	Scanner in1 = new Scanner(System.in); //second Scanner object for lottory lines, so it does not conflict with numbers input.
    
    // declare constructors
	public UserLotteryInput(){
		//default values will be used
	}
	
	//setter method for number of lottery lines
	public void setLines(int lines){
       	lines = lines;
	}
	
	//setter method for lottery numbers 
	public void setUserNumbers(int userNumbers[][]){
		this.userNumbers = userNumbers;
	}

	//processing - accepts and validate user's input
	public void computeUserLotteryInput(){
				
		System.out.println("Please enter how many Lines you wish to play: ");
        	lines = in1.nextInt();
		// code checks that users lottery line per game is between 1 and 3.
		if (lines < 1 || lines > 3)
		{
			while (lines < 1 || lines > 3)
			{
			System.out.println("Sorry, Only up to 3 lines per Game");
			lines = in.nextInt();
				if (lines >= 1 || lines <= 3)
				{
			 	     lines = lines;

				}
			}
		}
		
		userNumbers = new int [lines][numbersPerLine];
		int userInput = userNumbers[0][0];
		int count = 0;
		// code traverse 2D array and checks if number is between 1 and 40 and if there are unique numbers per line.
		for (int i = 0; i< userNumbers.length; i++) {
			System.out.println("Enter 6 numbers for Line " + (i+1));
			for (int j = 0; j < userNumbers[i].length; j++){
			     	userInput = in.nextInt();
				// checks that all number entered are between 1 and 40
				if (userInput < low || userInput > high)
				{
					while (userInput < low || userInput > high)
					{
					System.out.println("Incorrect number entered! \nPlease enter lottery number (between 1 and 40) ");
					userInput = in.nextInt();
						if (userInput >= low || userInput <= high)
						{
					 	     userNumbers[i][j] = userInput;

						}
					}
				}
			   	boolean unique = true; // code checks that only unique numbers are stored per lottery line
				for (int g = 0; g < j; g++){
					if (userNumbers[i][g] == userInput){
						unique = false;

					}
				}
					if(unique == true){
						userNumbers[i][j] = userInput;
						count++;
					}else {
						System.out.println("Number already provided");
						j--;
					}
			
			}
				userLines = userNumbers[i];
		}
	}
	
	// getter method to send users numbers to the App class.
	public int[][] getUserLines(){
		return userNumbers;
		}
} // ends of UserLotteryInput class
