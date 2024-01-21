// Shani Zahavi 211305271, Leon Petrov 314821521

package XO;

import java.util.ArrayList;

public abstract class Game {

	private final int SIZE = 5;
	private final int WIN_CONDITION = 4;
	protected String[][] gameBoard;
	protected playerType turn;
	protected boolean gameOver = false;

	// constructor
	public Game() {
		gameBoard = new String[SIZE][SIZE];
		initializeBoard();
		this.turn = playerType.X; // x begins the game always
	}

	// prints the board
	public void printBoard() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(gameBoard[i][j] + " ");
			}
			System.out.println();
		}
	}

	// get all empty cells on the board
	public ArrayList<Coordinate> getFreeCells() {
		ArrayList<Coordinate> freeCells = new ArrayList<>();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (gameBoard[i][j] == " ") { // " " == empty cell
					freeCells.add(new Coordinate(i, j));
				}
			}
		}
		return freeCells;
	}

	// check if win condition is met for any of the possibilities
	public boolean checkWin(playerType pt, Coordinate coordinate) {
		if (checkLeftDiagonal(pt, coordinate) >= WIN_CONDITION)
			return true;
		if (checkRightDiagonal(pt, coordinate) >= WIN_CONDITION)
			return true;
		if (checkHorizontal(pt, coordinate) >= WIN_CONDITION)
			return true;
		if (checkVertical(pt, coordinate) >= WIN_CONDITION)
			return true;
		return false;
	}

	// check win condition for left diagonal on the board
	private int checkLeftDiagonal(playerType pt, Coordinate coordinate) {
		int sequence = 1;
		int x = coordinate.getRow();
		int y = coordinate.getCol();

		// above coordinate
		for (int i = x - 1; i > 0; i--) {
			if (y - 1 < 0)
				break;
			if (gameBoard[i][y-1] == pt.value()) {
				sequence++;
				y--;
			} else
				break;
		}

		// below coordinate
		y = coordinate.getCol();
		for (int i = x + 1; i < SIZE; i++) {
			if (y + 1 >= SIZE)
				break;
			if (gameBoard[i][y+1] == pt.value()) {
				sequence++;
				y++;
			} else
				break;
		}
		return sequence;
	}

	// check win condition for right diagonal on the board
	private int checkRightDiagonal(playerType pt, Coordinate coordinate) {
		int sequence = 1;
		int x = coordinate.getRow();
		int y = coordinate.getCol();

		// above coordinate
		for (int i = x - 1; i >= 0; i--) {
			if (y + 1 >= SIZE)
				break;
			if (gameBoard[i][y+1] == pt.value()) {
				sequence++;
				y++;
			} else
				break;
		}

		// below coordinate
		y = coordinate.getCol();
		for (int i = x + 1; i < SIZE; i++) {
			if (y - 1 < 0)
				break;
			if (gameBoard[i][y-1] == pt.value()) {
				sequence++;
				y--;
			} else
				break;
		}
		return sequence;
	}

	// check win condition for vertical line on the board
	private int checkVertical(playerType pt, Coordinate coordinate) {
		int sequence = 1;
		int x = coordinate.getRow();
		int y = coordinate.getCol();

		// check above coordinate
		for (int i = x - 1; i >= 0; i--) {
			if (gameBoard[i][y] == pt.value()) {
				sequence++;
			} else
				break;
		}
		// check below coordinate
		for (int i = x + 1; i < SIZE; i++) {
			if (gameBoard[i][y] == pt.value()) {
				sequence++;
			} else
				break;
		}

		return sequence;
	}

	// check win condition for horizontal line on the board
	private int checkHorizontal(playerType pt, Coordinate coordinate) {
		int sequence = 1; // max value SIZE-1
		int x = coordinate.getRow();
		int y = coordinate.getCol();

		// check right to coordinate
		for (int i = y + 1; i < SIZE; i++) {
			if (gameBoard[x][i] == pt.value()) {
				sequence++;
			} else
				break;
		}
		// check left to coordinate
		for (int i = y - 1; i >= 0; i--) {
			if (gameBoard[x][i] == pt.value()) {
				sequence++;
			} else
				break;
		}
		return sequence;

	}

	// returns false if the board is full
	public boolean isCellsLeft() {
		return getFreeCells().size() > 0;
	}

	// getter
	public playerType getTurn() {
		return turn;
	}

	// switch enum type for next turn 
	public synchronized void switchTurn() {
		turn = (turn == playerType.X) ? playerType.O : playerType.X;
	}

	// fill cell on the board in given coordinate
	// check if there is a win and switch turns accordingly
	public synchronized void fillCell(Coordinate coordinate, playerType playerType) {
		gameBoard[coordinate.getRow()][coordinate.getCol()] = playerType.value();
		gameOver = checkWin(playerType, coordinate);
		if (!gameOver)
			switchTurn();
		printBoard();
	}

	// fill board with " "
	public void initializeBoard() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				gameBoard[i][j] = " ";
			}
		}
	}
}
