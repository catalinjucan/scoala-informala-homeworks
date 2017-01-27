package tema9;

import java.io.Serializable;

/*
 * This is the Participant class, which contains all the elements that a participant object needs.
 */

public class Participant implements Serializable, Comparable<Participant> {

	private static final long serialVersionUID = 1L;

	private String athleteName;
	private String timeElapsed;
	private String countryCode;
	private String participantNumber;
	private int time;
	private int penalization;

	public String getAthleteName() {
		return athleteName;
	}

	public void setAthleteName(String athleteName) {
		this.athleteName = athleteName;
	}

	public String getTimeElapsed() {
		return timeElapsed;
	}

	public void setTimeElapsed(String timeElapsed) {
		this.timeElapsed = timeElapsed;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getParticipantNumber() {
		return participantNumber;
	}

	public void setParticipantNumber(String participantNumber) {
		this.participantNumber = participantNumber;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getPenalization() {
		return penalization;
	}

	public void setPenalization(int penalization) {
		this.penalization = penalization;
	}

	@Override
	public String toString() {
		return countryCode + " " + participantNumber + "/" + athleteName + " "
				+ getTimeAsString() + " ( " + timeElapsed + " + "
				+ penalization + " )";
	}

	// This method helps sort the participants according to the final time
	@Override
	public int compareTo(Participant o) {
		int result = 0;
		if (o != null) {
			result = Integer.compare(this.time, o.getTime());
		} else {
			result = 2;
		}
		return result;

	}

	// This method calculates the time penalty according to the misses they have
	// at the shooting range
	public void calculatePenalty(String pen) {
		int pent = 0;
		for (int i = 0, n = pen.length(); i < n; i++) {
			char c = pen.charAt(i);
			if (c == 'o') {
				pent += 10;
			}
		}
		this.time += pent;
		this.penalization += pent;
	}

	// This method transforms the final time from seconds in date format
	private String getTimeAsString() {

		int minutes = (this.time % 3600) / 60;
		int seconds = this.time % 60;

		return String.format("%02d:%02d", minutes, seconds);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((athleteName == null) ? 0 : athleteName.hashCode());
		result = prime * result
				+ ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime
				* result
				+ ((participantNumber == null) ? 0 : participantNumber
						.hashCode());
		result = prime * result + (penalization ^ (penalization >>> 32));
		result = prime * result + (time ^ (time >>> 32));
		result = prime * result
				+ ((timeElapsed == null) ? 0 : timeElapsed.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participant other = (Participant) obj;
		if (athleteName == null) {
			if (other.athleteName != null)
				return false;
		} else if (!athleteName.equals(other.athleteName))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (participantNumber == null) {
			if (other.participantNumber != null)
				return false;
		} else if (!participantNumber.equals(other.participantNumber))
			return false;
		if (penalization != other.penalization)
			return false;
		if (time != other.time)
			return false;
		if (timeElapsed == null) {
			if (other.timeElapsed != null)
				return false;
		} else if (!timeElapsed.equals(other.timeElapsed))
			return false;
		return true;
	}

}
