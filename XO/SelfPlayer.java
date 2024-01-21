// Shani Zahavi 211305271, Leon Petrov 314821521

package XO;

import java.util.Random;

public class SelfPlayer extends Player implements Runnable {

	public Thread playerThread;

	// constructor
	public SelfPlayer(playerType turn, Game game) {
		super(game, turn);
		this.playerThread = new Thread(this);
	}

	// implements runnable
	public void run() {
		while (this.game.isCellsLeft() && !this.game.gameOver) {
			if (this.game.getTurn() == this.turn) {
				System.out.println(this.turn+ "'s move:"+"\n");
				
				// make a move with a random available cell
				Random random = new Random();
				this.play(game.getFreeCells().get(random.nextInt(game.getFreeCells().size())));
				
				// check post-move status
				if (this.game.gameOver) {
					System.out.println("player " + this.turn + " has won!");
					return;
				}
				if (!this.game.isCellsLeft()) {
					System.out.println("Board is full");
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

}
