package blackJack;
/**
 * A class to manage the betting for each round
 * @author Adam Wiener
 *
 */
public class Betting {
	private int _balance;
	private boolean _betMade;
	private int _bet;

	public Betting(int balance) {
		_balance = balance;
		_betMade = false;
	}

	public void makeBet(int bet) {
		if (bet > _balance) {
			System.out.println("You tried to bet $" + bet + " but only have $" + _balance);
		} else if (bet < 1) {
			System.out.println("Please bet a valid amount");
		} else {
			System.out.println("You bet $" + bet);
			_bet = bet;
			_balance = _balance - _bet;
			_betMade = true;
		}
	}

	public void blackjack() {
		_balance += (int)(_bet*1.5);
		_betMade = false;
	}

	public void win() {
		_balance += _bet*2;
		_betMade = false;
	}

	public void loss() {
		_betMade = false;
	}
	
	public void draw() {
		_balance += _bet;
		_betMade = false;
	}

	public int getBalance() {
		return _balance;
	}

	public boolean betPlaced() {
		return _betMade;
	}
}
