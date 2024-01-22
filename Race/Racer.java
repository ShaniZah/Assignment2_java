// Shani Zahavi 211305271, Leon Petrov 314821521

package Race;

public class Racer implements Runnable {
	private static int globalId = 1;
	private int id;
	private int speed;
	private Track track;

	public Racer(int speed, Track track) {
		id = globalId;
		globalId++;
		if (speed < 1 || speed > 10) {
			System.out.println("invalid speed. set to default value: 1");
			speed = 1;
		} else {
			this.speed = speed;
		}
		this.track = track;
	}

	public synchronized void go() {
		int i;

		// prioritize thread to be == speed
		Thread.currentThread().setPriority(speed);

		for (i = 1; i <= 100; i++) {
			System.out.println(String.format("Runner %d ran %d meters", id, i));
			if (i == 100) { // customized printings for each finished racer
				track.setFinishedRacers();
				switch (track.getFinishedRacers()) {
				case 1: {
					System.out.println(String.format("Runner %d finished %dst", id, track.getFinishedRacers()));
					break;
				}
				case 2: {
					System.out.println(String.format("Runner %d finished %dnd", id, track.getFinishedRacers()));
					break;
				}
				case 3: {
					System.out.println(String.format("Runner %d finished %drd", id, track.getFinishedRacers()));
					break;
				}
				default:
					System.out.println(String.format("Runner %d finished %dth", id, track.getFinishedRacers()));
					break;
				}
			}
		}

	}

	@Override
	public void run() {
		go();
	}
}
