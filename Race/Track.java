// Shani Zahavi 211305271, Leon Petrov 314821521

package Race;


public class Track {
	private int finishedRacers;
	
	//constructor
	public Track() {
		finishedRacers = 0;
	}
	
	//getter
	public int getFinishedRacers() {
		return finishedRacers;
	}
	
	//setter - increment number of finished racers
	public synchronized void setFinishedRacers() {
		finishedRacers++;
	}
}
