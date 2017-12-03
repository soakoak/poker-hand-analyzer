package poker;

public enum Suit {
	HEARTS('\u2764'), DIAMONDS('\u2666'), CLUBS('\u2663'), SPADES('\u2660');
	
	private final char icon;
	
	private Suit(char icon) {
		this.icon = icon;
	}
	
	public char getIcon() {
		return this.icon;
	}
	
	@Override
	public String toString() {
		return Character.toString(this.icon);
	}
}
