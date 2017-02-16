package tema10;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/*
 * This is the main class, which allows us to create a pool of attendee Threads.
 */
public class Main {

	private static final Random RANDOM = new Random();

	public static void main(String[] args) {

		FestivalGate gate = new FestivalGate();

		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors
				.newFixedThreadPool(5);
		{
			for (int i = 0; i < 1000; i++) {
				TicketType ticketType = Main.randomTicket();
				FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(
						ticketType, gate);
				executor.execute(festivalAttendee);
			}
			executor.shutdown();
		}

		FestivalStatisticsThread statsThread = new FestivalStatisticsThread(
				gate);

		statsThread.run();
	}

	// This method allows us to generate a random Ticket Type
	public static TicketType randomTicket() {

		return TicketType.values()[RANDOM.nextInt(TicketType.values().length)];
	}

}
