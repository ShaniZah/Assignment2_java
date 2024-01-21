// Shani Zahavi 211305271, Leon Petrov 314821521

package XO;

public class UserGame extends Game{
	private SelfPlayer playerX;
    private UserPlayer playerO;

    //constructor 
    public UserGame() {
    	super();
        this.playerO = new UserPlayer(this, playerType.O);
        this.playerX = new SelfPlayer(playerType.X,this);
    }
    
    // start the thread of player O
    public void startGame() {
    	playerX.playerThread.start();
		playerO.playerThread.start();
	}

}
