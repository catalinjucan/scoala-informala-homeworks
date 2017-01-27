package tema9;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

/*
 * This is the main class, which allows the connection between the CSV and the Participant class.
 * And to display the elements from the CSV int the way is set in Participant.
 */
public class Main {

	public static void main(String[] args) throws IOException {

		File csvFile = new File("D:/Programare/Workspace/IO/participants.csv");

		try (CSVParticipantReader reader = new CSVParticipantReader(
				Files.newBufferedReader(csvFile.toPath(),
						StandardCharsets.UTF_8))) {
			List<Participant> participants = reader.readParticipants();
			for (Participant b : participants) {
				System.out.println(b.toString());
			}
		}

	}

}
