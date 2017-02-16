package tema10;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * This class acts as the buffer between the producer and consumer.
 */
public class FestivalGate {

	private final BlockingQueue<TicketType> sharedQueue = new LinkedBlockingQueue<TicketType>();

	// This method allows us to assign Ticket Type to each Attendee Thread.
	public synchronized void setAttendees(TicketType ticketType)
			throws InterruptedException {
		sharedQueue.put(ticketType);

	}

	// This method allows the Threads to be grouped by Ticket Type, and to
	// display the sum of all types of Tickets every 5 sec
	public synchronized Map<TicketType, Integer> getStatistics()
			throws InterruptedException {
		final Map<TicketType, Integer> all = new ConcurrentHashMap<>();

		for (TicketType t : sharedQueue) {
			int count = all.containsKey(t) ? all.get(t) : 0;
			all.put(t, count + 1);
		}
		wait(5000);
		int sum = 0;
		for (int f : all.values()) {
			sum += f;
		}
		System.out.println("Number of tickets checked is: " + sum);
		notifyAll();

		return all;

	}

}
