package poker;

public enum Rank {
	_2(2), _3(3), _4(4), _5(5), _6(6), _7(7), _8(8), _9(9), _10(10), J(11), Q(12), K(13), A(14);
	
	private final int value;
	
	private Rank(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		if(this.value < 11) {
			return Integer.toString( this.value );
		} else {
			return this.name();
		}
	}
}
