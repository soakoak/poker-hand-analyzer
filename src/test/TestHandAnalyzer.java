package test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import poker.Card;
import poker.Rank;
import poker.Suit;
import poker.util.HandAnalyzer;

public class TestHandAnalyzer {
	
	private ArrayList<Card> hand = new ArrayList<Card>(5);
	private HandAnalyzer analyzer = new HandAnalyzer();
	
	@Before
	public void setUp() {
		this.hand.clear();
	}

	@Test
	public void testHasTwoPairs() {
		// make hand of five Cards, with two pairs
		this.hand.add(new Card(Suit.HEARTS, Rank.J));
		this.hand.add(new Card(Suit.SPADES, Rank.Q));
		this.hand.add(new Card(Suit.CLUBS, Rank.Q));
		this.hand.add(new Card(Suit.HEARTS, Rank._6));
		this.hand.add(new Card(Suit.DIAMONDS, Rank._6));
		
		assertTrue("hasTwoPairs returns true for hand with two pairs.", analyzer.hasTwoPairs(hand));
		
		//break one of the pairs
		hand.set(4, new Card(Suit.DIAMONDS, Rank._2));
		assertFalse("hasTwoPairs return false for hand with one pair.", analyzer.hasTwoPairs(hand));
	}

	@Test
	public void testHasFlush() {
		//make hand of five Card, all with same suit
		hand.add(new Card(Suit.SPADES, Rank._2));
		hand.add(new Card(Suit.SPADES, Rank.A));
		hand.add(new Card(Suit.SPADES, Rank.K));
		hand.add(new Card(Suit.SPADES, Rank._9));
		hand.add(new Card(Suit.SPADES, Rank._6));

		assertTrue("hasFlush returns true for hand with unified suit.", analyzer.hasFlush(hand));
		
		//break the flush
		this.hand.set(0, new Card(Suit.DIAMONDS, Rank._7));
		assertFalse("hasFlush returns false for hand with four same suits.", analyzer.hasFlush(hand));
	}
	
	@Test
	public void testHasStraight() {
		//make hand with each card one rank lower than the next card after sort.
		hand.add(new Card(Suit.CLUBS, Rank.K));
		hand.add(new Card(Suit.HEARTS, Rank.J));
		hand.add(new Card(Suit.SPADES, Rank.Q));
		hand.add(new Card(Suit.HEARTS, Rank._9));
		hand.add(new Card(Suit.DIAMONDS, Rank._10));

		assertTrue("hasStraight returns true for hand with straight.", analyzer.hasStraight(hand));
		
		//break the straight
		this.hand.set(0, new Card(Suit.HEARTS, Rank.Q));
		assertFalse("hasStraight returns false for hand with 4-straight", analyzer.hasStraight(hand));
	}
}
