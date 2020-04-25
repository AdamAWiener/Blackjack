package blackJack;

import java.util.Scanner;
/**
 * A class to run a round of blackjack with the appropriate game logic.
 * @author Adam Wiener
 *
 */
public class Round {
	private boolean _win;
	private boolean _bust;
	private boolean _blackjack;
	private boolean _draw;
	private Deck _deck;
	private Hand _dealer;
	private Hand _player;
	private Scanner userInput;

	public Round(Scanner userInput) {
		_win = false;
		_bust = false;
		_blackjack = false;
		_draw = false;
		_deck = new Deck();
		_dealer = new Hand();
		_player = new Hand();
		this.userInput = userInput;
	}

	public void play() {
		_deck.shuffleDeck();
		//deal the player and the dealer two cards each
		initialDeal();
		System.out.println("Dealer has: " + _dealer.getCardFromHand(0).displayCard() +" []");
		playerHandWithScore();

		if (_player.handValue() == 21) {
			System.out.println("Blackjack! You win!");
			_blackjack = true;
		}
		//perform player and dealer turns
		playerMove();
		dealerMove();
	}

	public void playerMove() {
		while (!_bust && !_blackjack) {
			if (hitOrStand() != 1) {
				break;
			}
			//draw a card and add to hand.
			Card drawnCard = _deck.drawTopCard();
			System.out.println("You were delt: " + drawnCard.displayCard());
			_player.addCardToHand(drawnCard);
			playerHandWithScore();
			//if new sum is greater than 21, then hand is bust.
			if (_player.handValue() > 21) {
				System.out.println("You went bust! \nThe dealer wins.\n");
				_bust = true;
				break;
			}
		}
	}

	public int hitOrStand(){
		System.out.println("\nWould you like to hit(1) or stand(2)?");
		int command = userInput.nextInt();
		if (command == 1) {
			System.out.println("You chose to hit.\n");
		} else {
			System.out.println("You chose to stand.\n");
		}
		return command;
	}

	public void dealerMove() {
		if (!_bust && !_blackjack) {
			//dealer draws while hand value is less than 17
			while (_dealer.handValue() < 17) {
				dealerHandWithScore();
				Card drawnCard = _deck.drawTopCard();
				_dealer.addCardToHand(drawnCard);
				System.out.println("The dealer drew: " + drawnCard.displayCard());
				//dealer busts over 21
				if (_dealer.handValue() > 21) {
					dealerHandWithScore();
					System.out.println("The dealer went bust. You win!");
					_win = true;
					break;
				}
			}
		}	
		//compare dealer hand and player hand and decide game outcome
		if (!_win && !_bust) {
			dealerHandWithScore();
			System.out.println("\nThe dealer has: " + _dealer.handValue() + " and you have " + _player.handValue());

			if (_dealer.handValue() > _player.handValue()) {
				System.out.println("The dealer wins.");	
			} else if (_dealer.handValue() == _player.handValue()) {
				System.out.println("The game is a draw.");
				_draw = true;
			} else {
				System.out.println("You win!");
				_win = true;
			}
		}
	}
	
	private void initialDeal() {
		_player.addCardToHand(_deck.drawTopCard());
		_dealer.addCardToHand(_deck.drawTopCard());
		_player.addCardToHand(_deck.drawTopCard());
		_dealer.addCardToHand(_deck.drawTopCard());
	}

	public boolean isBlackjack() {
		return _blackjack;
	}
	public boolean isWin() {
		return _win;
	}
	public boolean isDraw() {
		return _draw;
	}
	public void dealerHandWithScore() {
		System.out.println("The dealer has: " + _dealer.displayHandWithScore());
	}
	public void playerHandWithScore() {
		System.out.println("You have: " + _player.displayHandWithScore());
	}
}
