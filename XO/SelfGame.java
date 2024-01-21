// Shani Zahavi 211305271, Leon Petrov 314821521

package XO;

public class SelfGame extends Game {
	private SelfPlayer playerX;
	private SelfPlayer playerO;

	// constructor
	public SelfGame() {
		super();
		this.playerX = new SelfPlayer(playerType.X, this);
		this.playerO = new SelfPlayer(playerType.O, this);
	}
	
	// start threads for players 
	public void startGame() {
		playerX.playerThread.start();
		playerO.playerThread.start();
	}
	
}
