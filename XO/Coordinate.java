// Shani Zahavi 211305271, Leon Petrov 314821521

package XO;

public class Coordinate {
	private int row;
	private int col;

	public Coordinate(int row, int col) {
		this.col = col;
		this.row = row;
	}

	// getter
	public int getRow() {
		return row;
	}

	// getter
	public int getCol() {
		return col;
	}

	@Override
	// implement equals method 
	public boolean equals(Object c) {
		if (!(c instanceof Coordinate))
			return false;
		Coordinate other = (Coordinate) c;
		return this.row == other.getRow() && this.col == other.getCol();
	}

}
