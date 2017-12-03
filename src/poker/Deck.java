package poker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Deck implements Iterable<Card>{
	
	private List<Card> deck;
	
	public Deck() {
		this.deck = new ArrayList<Card>(52);
		for(Suit suit : Suit.values()) {
			for(Rank rank: Rank.values()) {
				Card card = new Card(suit, rank);
				this.deck.add(card);
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public Card draw() {
		int lastCardIdx = deck.size() - 1;
		Card lastCard = this.deck.get(lastCardIdx);
		this.deck.remove(lastCardIdx);
		return lastCard;
	}
	
	public ArrayList<Card> drawHand() {
		ArrayList<Card> hand = new ArrayList<>(5);
		for (int i = 0; i < 5; i++) {
			Card drawnCard = draw();
			hand.add(drawnCard);			
		}
		return hand;
	}
	
	public int size() {
		return this.deck.size();
	}
	

	@Override
	public Iterator<Card> iterator() {
		return deck.iterator();
	}
}
