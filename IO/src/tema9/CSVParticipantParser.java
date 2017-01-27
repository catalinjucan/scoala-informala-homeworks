package tema9;

/*
 * This class helps parse the Participant Object, according to the csv
 */

public class CSVParticipantParser {

	private static final String SEPARATOR = ",";
	private static final Integer ATHLETE_NUMBER = 0;
	private static final Integer ATHLETE_NAME = 1;
	private static final Integer COUNTRY_CODE = 2;
	private static final Integer SKI_TIME_RESULT = 3;
	private static final Integer FIRST_SHOOTONG_RANGE = 4;
	private static final Integer SECOND_SHOOTONG_RANGE = 5;
	private static final Integer THIRD_SHOOTONG_RANGE = 6;

	// This method parses the participant
	public Participant parseParticipant(String source) {
		Participant p = new Participant();
		String[] tokens = source.split(SEPARATOR);

		p.setAthleteName(tokens[ATHLETE_NAME]);
		p.setTimeElapsed(tokens[SKI_TIME_RESULT]);
		p.setCountryCode(tokens[COUNTRY_CODE]);
		p.setParticipantNumber(tokens[ATHLETE_NUMBER]);

		int time = minutesToSeconds(tokens[SKI_TIME_RESULT]);
		p.setTime(time);
		p.setPenalization(0);

		p.calculatePenalty(tokens[FIRST_SHOOTONG_RANGE]);
		p.calculatePenalty(tokens[SECOND_SHOOTONG_RANGE]);
		p.calculatePenalty(tokens[THIRD_SHOOTONG_RANGE]);

		return p;

	}

	// This method transforms the time from date format into seconds
	public int minutesToSeconds(String txt) {

		String timestampStr = txt;
		String[] token = timestampStr.split(":");
		int minutes = Integer.parseInt(token[0]);
		int seconds = Integer.parseInt(token[1]);
		int duration = 60 * minutes + seconds;

		return duration;
	}

}
