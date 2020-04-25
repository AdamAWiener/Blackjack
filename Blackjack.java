package blackJack; 
import java.util.Scanner;

/**
 * A simple one player Blackjack game with betting.
 * @author Adam Wiener
 * Date: 18/04/2020
 *
 */
public class Blackjack {

	private static boolean playAgain = true;

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		Betting _betting = new Betting(1000);
		System.out.println("Welcome to Blackjack!\nYou have $1000 starting cash.");
		//start game loop
		while (playAgain) {
			//perform betting
			while(!_betting.betPlaced()) {
				System.out.println("Please place a bet.");
				int bet = userInput.nextInt();
				_betting.makeBet(bet);
			}
			//create and play a new round
			Round _round = new Round(userInput);
			_round.play();
			//check game outcome and perform appropriate bet action
			if (_round.isBlackjack()) {
				_betting.blackjack();
			} else if (_round.isWin()) {
				_betting.win();
			} else if (_round.isDraw()){
				_betting.draw();
			} else {
				_betting.loss();
			}

			System.out.println("Your new balance is: " + _betting.getBalance());
			if(_betting.getBalance() == 0) {
				System.out.println("Game over");
				break;
			}	

			System.out.println("\nWould you like to play again? Input 1 for yes, 2 for no.");
			int command = userInput.nextInt();
			if (command == 2) {
				playAgain = false;
			}

		}	
		System.out.println("Your final balance is: " + _betting.getBalance());
		userInput.close();
	}
}







