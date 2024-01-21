// Shani Zahavi 211305271, Leon Petrov 314821521

package XO;

import java.util.ArrayList;

public class UserPlayer extends Player implements Runnable {

	public Thread playerThread;

	public UserPlayer(UserGame game, playerType turn) {
		super(game, turn);
		playerThread = new Thread(this);
	}

	public void run() {
		while (this.game.isCellsLeft() && !this.game.gameOver) {
			if (this.game.getTurn() == this.turn) {
				System.out.println("your move:");
				
				// make move with user-chosen coordinate
				Coordinate coordinate = getUserCoordinate();
				play(coordinate);
				
				// check post-move game status
				if (game.gameOver) {
					System.out.println("player " + this.turn + " has won!");
					Main.sc.close(); // close static scanner
					return;
				}
				if (!this.game.isCellsLeft()) {
					System.out.println("Board is full");
					Main.sc.close(); // close static scanner
					return;
				}
			} else {

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// get valid coordinate from user
	private synchronized Coordinate getUserCoordinate() {
		System.out.println("insert row and column number:" + "\n");
		System.out.print("row: ");
		int row = Main.sc.nextInt();
		System.out.print("column: ");
		int col = Main.sc.nextInt();
		Coordinate coordinate = new Coordinate(row, col);
		ArrayList<Coordinate> freeCells = game.getFreeCells();
		while (!freeCells.contains(coordinate)) {
			System.out.println("unavailable coordinate, choose again");
			row = Main.sc.nextInt();
			col = Main.sc.nextInt();
			coordinate = new Coordinate(row, col);
		}

		return coordinate;
	}

}
