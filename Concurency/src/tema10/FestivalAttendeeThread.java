package tema10;

import java.util.Random;

/*
 * This class acts like the producer, it also represents the attendees Thread. 
 */
public class FestivalAttendeeThread implements Runnable {

	private final TicketType ticketType;
	private final FestivalGate festivalGate;

	public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
		this.festivalGate = gate;
		this.ticketType = ticketType;

	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public FestivalGate getFestivalGate() {
		return festivalGate;

	}

	@Override
	public void run() {
		Random random = new Random();
		try {
			synchronized (this) {
				wait(random.nextInt(500));
			}
			this.festivalGate.setAttendees(ticketType);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
