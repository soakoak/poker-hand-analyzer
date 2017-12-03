package poker.util;

import java.util.List;

import poker.Card;
import poker.Rank;
import poker.Suit;

public class HandAnalyzer {
	
	public HandType analyze(List<Card> hand) {
		if( hasTwoPairs(hand) ) {
			return HandType.TWO_PAIRS;
		}

		boolean hasStraight = hasStraight(hand);
		boolean hasFlush = hasFlush(hand);
		
		//test for straight flush before flush and straight
		if(hasFlush && hasStraight) {
			return HandType.STRAIGHT_FLUSH;
		} else if(hasStraight) {
			return HandType.STRAIGHT;
		} else if(hasFlush) {
			return HandType.FLUSH;
		}
		
		//nothing found
		return HandType.NOTHING;
	}
	
	public boolean hasTwoPairs(List<Card> hand) {
		// line up cards with same rank
		hand.sort(new Card.RankComparator());
		
		Rank pair1 = null;
		Rank pair2 = null;
		for(int i = 0; i < 4; i++) {
			Card c = hand.get(i);
			if(c.getRank().equals( hand.get(i+1).getRank() )) {
				if(pair1 == null) {
					pair1 = c.getRank();
				} else {
					pair2 = c.getRank();
				}
				i++; //skip card already in pair
			}
		}
		
		return pair1 != null && pair2 != null;
	}
	
	public boolean hasFlush(List<Card> hand) {
		// set Suit we are looking for
		Suit s = hand.get(0).getSuit();
		
		//fail if a suit is different from rest
		for (Card c : hand) {
			if(c.getSuit() != s) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean hasStraight(List<Card> hand) {
		
		hand.sort(new Card.RankComparator());
		
		/*
		 *  Every card should be one rank lower than the next card after sort.
		 *  In other words, lower rank card's value should be one lower than the next card's.
		 */
		for(int i = 0 ; i < 4 ; i++) {
			int lowerCardValue = hand.get(i).getRank().getValue();
			int higherCardValue = hand.get(i+1).getRank().getValue();
			
			if(higherCardValue - lowerCardValue != 1) {
				return false;
			}
		}
		return true;
	}
}
