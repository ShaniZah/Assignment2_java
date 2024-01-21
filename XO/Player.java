// Shani Zahavi 211305271, Leon Petrov 314821521

package XO;



public abstract class Player {
	protected Game game;
	protected playerType turn;
	
	// constructor
	public Player(Game game, playerType turn) {		
		this.game = game;
		this.turn = turn;
	}
	
	// make the moves on the board
	protected synchronized void play(Coordinate coordinate) {
		this.game.fillCell(coordinate, turn);
	}
	
}
