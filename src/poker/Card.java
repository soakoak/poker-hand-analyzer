package poker;

import java.util.Comparator;

public class Card implements Comparable<Card> {

	private final Suit suit;
	private final Rank rank;
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public int compareTo(Card c) {
		int rankComparison = this.rank.compareTo(c.rank);
		if (rankComparison == 0) {
			return this.suit.compareTo(c.suit);
		} else {
			return rankComparison;
		}
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public Rank getRank() {
		return this.rank;
	}
	
	public static class RankComparator implements Comparator<Card> {

		@Override
		public int compare(Card c1, Card c2) {
			int rankComparison = c1.getRank().compareTo( c2.getRank() );
			
			if (rankComparison == 0) {
				return c1.getSuit().compareTo( c2.getSuit() );
			} else {
				return rankComparison;
			}
		}
		
	}
}
