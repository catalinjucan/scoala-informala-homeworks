package tema9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * This class reads the participants after they are parsed.
 */
public class CSVParticipantReader extends BufferedReader {

	CSVParticipantParser pp = new CSVParticipantParser();

	public CSVParticipantReader(Reader in) {
		super(in);
	}

	// this method returns the csv elements according to the way they are parsed
	public List<Participant> readParticipants() throws IOException {
		ArrayList<Participant> participants = new ArrayList<>();
		String line = readLine();
		while (line != null) {
			Participant participant = pp.parseParticipant(line);
			participants.add(participant);
			line = readLine();
		}
		Collections.sort(participants);
		return participants;
	}
}
