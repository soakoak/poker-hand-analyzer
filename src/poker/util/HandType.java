package poker.util;

public enum HandType {

	NOTHING, TWO_PAIRS, FLUSH, STRAIGHT, STRAIGHT_FLUSH;
	
	@Override
	public String toString() {
		return this.name().toLowerCase().replace('_', ' ');
	}
}
