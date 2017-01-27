import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.junit.Test;

import tema9.CSVParticipantParser;
import tema9.CSVParticipantReader;
import tema9.Participant;

public class CSVParticipantParserTest {

	@Test
	public void whenParsingCSVlList_ofParticipantList_shuldReturnInWinningOrder()
			throws IOException {

		CSVParticipantParser cp = new CSVParticipantParser();

		String csv = "17,Piere Bombardier,CA,31:27,xxxxx,xxxxx,xxxxo\n"
				+ "25,Bjorn Borg,NO,30:27,xxxox,xxoxx,xxoxo\n"
				+ "6,Otto Klaus,DE,28:59,xxxox,xxoox,xxoxo\n";

		StringReader sr = new StringReader(csv);

		try (CSVParticipantReader partreader = new CSVParticipantReader(sr)) {
			List<Participant> participants = partreader.readParticipants();
			assertEquals(3, participants.size());

			Participant p1 = new Participant();
			p1.setAthleteName("Otto Klaus");
			p1.setTimeElapsed("28:59");
			p1.setCountryCode("DE");
			p1.setParticipantNumber("6");
			int t1 = cp.minutesToSeconds("28:59");
			p1.setTime(t1);
			p1.setPenalization(0);
			p1.calculatePenalty("xxxox");
			p1.calculatePenalty("xxoox");
			p1.calculatePenalty("xxoxo");

			Participant p2 = new Participant();
			p2.setAthleteName("Bjorn Borg");
			p2.setTimeElapsed("30:27");
			p2.setCountryCode("NO");
			p2.setParticipantNumber("25");
			int t2 = cp.minutesToSeconds("30:27");
			p2.setTime(t2);
			p2.setPenalization(0);
			p2.calculatePenalty("xxxox");
			p2.calculatePenalty("xxoxx");
			p2.calculatePenalty("xxoxo");

			Participant p3 = new Participant();
			p3.setAthleteName("Piere Bombardier");
			p3.setTimeElapsed("31:27");
			p3.setCountryCode("CA");
			p3.setParticipantNumber("17");
			int t3 = cp.minutesToSeconds("31:27");
			p3.setTime(t3);
			p3.setPenalization(0);
			p3.calculatePenalty("xxxxx");
			p3.calculatePenalty("xxxxx");
			p3.calculatePenalty("xxxxo");

			Participant[] expected = new Participant[] { p1, p2, p3 };
			Participant[] actual = new Participant[3];
			participants.toArray(actual);
			assertArrayEquals(expected, actual);

		}
	}
}
