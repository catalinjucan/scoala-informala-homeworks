package tema10;

/*
 * This class acts like the consumer, and represents the statistics Thread
 */

public class FestivalStatisticsThread implements Runnable {

	private final FestivalGate festivalGate;

	public FestivalStatisticsThread(FestivalGate gate) {
		this.festivalGate = gate;
	}

	public FestivalGate getFestivalGate() {
		return festivalGate;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(this.festivalGate.getStatistics());
			} catch (InterruptedException e) {

			}
		}
	}
}
