import static org.junit.Assert.assertSame;

import java.util.Map;

import org.junit.Test;

import tema10.FestivalAttendeeThread;
import tema10.FestivalGate;
import tema10.TicketType;

public class ConcurencyTest {

	FestivalGate gate = new FestivalGate();

	@Test
	public void testForOneTicketType() throws InterruptedException {
		FestivalAttendeeThread festivalAttendee1 = new FestivalAttendeeThread(
				TicketType.FREE_PASS, gate);
		festivalAttendee1.run();
		Map<TicketType, Integer> result = gate.getStatistics();
		assertSame(result.get(TicketType.FREE_PASS), 1);
	}

	@Test
	public void testForMoreTicketType() throws InterruptedException {
		FestivalAttendeeThread festivalAttendee1 = new FestivalAttendeeThread(
				TicketType.FREE_PASS, gate);
		FestivalAttendeeThread festivalAttendee2 = new FestivalAttendeeThread(
				TicketType.FULL, gate);
		FestivalAttendeeThread festivalAttendee3 = new FestivalAttendeeThread(
				TicketType.FREE_PASS, gate);
		FestivalAttendeeThread festivalAttendee4 = new FestivalAttendeeThread(
				TicketType.FREE_PASS, gate);
		FestivalAttendeeThread festivalAttendee5 = new FestivalAttendeeThread(
				TicketType.FULL_VIP, gate);

		festivalAttendee1.run();
		festivalAttendee2.run();
		festivalAttendee3.run();
		festivalAttendee4.run();
		festivalAttendee5.run();

		Map<TicketType, Integer> result = gate.getStatistics();
		assertSame(result.get(TicketType.FREE_PASS), 3);
		assertSame(result.get(TicketType.FULL), 1);
		assertSame(result.get(TicketType.FULL_VIP), 1);
	}

	@Test
	public void testForNoTicketType() throws InterruptedException {
		FestivalAttendeeThread festivalAttendee1 = new FestivalAttendeeThread(
				TicketType.FREE_PASS, gate);
		festivalAttendee1.run();
		Map<TicketType, Integer> result = gate.getStatistics();
		assertSame(result.get(TicketType.FULL), null);
	}

}
