// Shani Zahavi 211305271, Leon Petrov 314821521

package XO;

public enum playerType {

	X("x"), O("o");

	private final String value;

	// constructor
	private playerType(String value) {
		this.value = value;
	}

	// get value
	public String value() {
		return value;
	}
}
