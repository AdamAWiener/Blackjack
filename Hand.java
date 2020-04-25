package blackJack;
import java.util.ArrayList;
import java.util.List;
/**
 * A class to represent the hand of cards of either a dealer or player
 * @author Adam Wiener
 *
 */
public class Hand {
	private List<Card> _cards;
	
	public Hand () {
		_cards = new ArrayList<Card>();
	}
	
	public void addCardToHand(Card card) {
		_cards.add(card);
	}
	
	public int handValue() {
		int score = 0;
		for (Card card: _cards) {
			int cardVal = card.getCardValue();
			if (cardVal == 1 && score < 11) {
				cardVal = 11;
			}
			score += cardVal;
			}
		return score;
	}
		
	public Card getCardFromHand(int pos){
		if (pos > _cards.size() || _cards.size() == 0) {
			return null;
		}
		return _cards.get(pos);
	}
	
	public String displayHand() {
		if (_cards.size() == 0) {
			return "";
		}
		String string = "";
		for (int i = 0; i<_cards.size(); i++) {
			string = string  + _cards.get(i).displayCard() + " ";
		}

		return string;
	}
	
	public String displayHandWithScore() {
		String string = displayHand() + "Score: "+ handValue();
		return string;
	}
	
}
