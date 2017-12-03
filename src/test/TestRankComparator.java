package test;

import static org.junit.Assert.*;

import org.junit.Test;

import poker.Card;
import poker.Rank;
import poker.Suit;
import poker.Card.RankComparator;

public class TestRankComparator {

	@Test
	public void testCompare() {
		RankComparator comparator = new Card.RankComparator();
		
		Card spadeQ = new Card(Suit.SPADES, Rank.Q);
		Card diamond9 = new Card(Suit.DIAMONDS, Rank._9);
		Card heartQ = new Card(Suit.HEARTS, Rank.Q);
		
		int compareResult = comparator.compare(diamond9, spadeQ);
		assertTrue("Result of comparing lower rank to higher should be less than 0", compareResult < 0);
		
		compareResult = comparator.compare(spadeQ, diamond9);
		assertTrue("Result of comparing higher rank to lower should be less than 0", compareResult > 0);
		
		compareResult = comparator.compare(spadeQ, heartQ);
		int suitCompareResult = spadeQ.getSuit().compareTo( heartQ.getSuit() );
		assertTrue("Result of comparing same ranked cards should be same as Suit.compareTo", compareResult == suitCompareResult);
	}
}
