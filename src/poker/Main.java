package poker;

import java.util.List;

import poker.util.HandAnalyzer;
import poker.util.HandType;

public class Main {
	
	private static String handToString(List<Card> hand) {
		Card currentCard;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 4; i++) {
			currentCard = hand.get(i);
			sb.append(currentCard.getRank().toString());
			sb.append(currentCard.getSuit().toString());
			sb.append(", ");
		}
		currentCard = hand.get(4);
		sb.append(currentCard.getRank().toString());
		sb.append(currentCard.getSuit().toString());
		
		return sb.toString();
	}

	public static void main(String[] args) {
		Deck deck = new Deck();	
		HandAnalyzer analyzer = new HandAnalyzer();
		
		log("The program will draw three 5-card hands from a shuffled deck, and do analyzis on them." 
				+ " The supported poker hand types are two pairs, flush, straight, straight flush, and nothing.");
		deck.shuffle();
		
		for(int i = 1; i < 4; i++) {
			System.out.print("Hand #" + i + ": ");
			List<Card> hand = deck.drawHand();
			
			// sort hand before printing
			hand.sort(new Card.RankComparator());
			log(handToString(hand));
			
			HandType analysisResult = analyzer.analyze(hand);
			log("Analysis result: the drawn hand contains " + analysisResult);
		}
	}
	
	public static void log(String str) {
		System.out.println(str);
	}
}
