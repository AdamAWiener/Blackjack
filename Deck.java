package blackJack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Math;
/**
 * A class to represent a full deck of cards for the game
 * @author Adam Wiener
 *
 */
public class Deck {
	private List<Card> _cards;
	
	public Deck() {
		_cards = new ArrayList<Card>();
		//label each card in the deck 1 - 52
		for (int i = 1; i < 53; i++) {
			_cards.add(new Card(i));
		}
	}
	
	public void shuffleDeck() {
		//go through each card and swap with another random card
		for (int i = 0; i < 52; i++) {
			int pos = (int)(Math.random()*52);
			Collections.swap(_cards, i, pos);
		}
	}
	
	public Card drawTopCard() {
		if (_cards.size() == 0) {
			return null;
		}
		Card topCard = _cards.get(0);
		_cards.remove(0);
		return topCard;
	}
	
	public String displayDeck() {
		String string = "";
		int i = 0;
		for (Card card: _cards) {
			i++;
			string = string + " " + i + card.displayCard();
			
		}
		return string;
	}

}
