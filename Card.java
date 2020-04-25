package blackJack;
/**
 * A class to represent an individual card
 * @author Adam Wiener
 *
 */
public class Card {
	private static final char[] ranks = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
	private char _suit;
	private int _rank;
	
	public Card(int code) {
		_suit = findSuit(code);
		_rank = findRank(code);
	}
	
	private char findSuit(int code) {
		if (code < 14) {
			return 'S';
		} else if (code < 27) {
			return 'C';
		} else if (code < 40) {
			return 'D';
		} else {
			return 'H';
		}
	}
	
	private int findRank(int code) {
		return code%13+1;
	}

	public String displayCard() {
		return "["+ranks[_rank-1] + String.valueOf(_suit)+"]";
	}
	
	public int getCardValue() {
		if (_rank < 11) {
			return _rank;
		} else {
			return 10;
		}
	}	
}

