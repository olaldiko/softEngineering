
public class TimeParser {
	private static final int MINS_PER_HR = 60;
	private static final int SECS_PER_MIN = 60;
	
	private static final int MIN_HRS = 0;
	private static final int MAX_HRS = 23;
	private static final int MIN_MINS = 0;
	private static final int MAX_MINS = 59;
	private static final int MIN_SECS = 0;
	private static final int MAX_SECS = 59; // ignore leap seconds
	
	public static int parseTimeToSeconds(String time) throws NumberFormatException {
		// Normalize the input (trim whitespace and make lower case)
		time = time.trim().toLowerCase();
		
		int firstColon = time.indexOf(':');
		if (firstColon == -1) {
			throw new NumberFormatException("Unrecognized time format first colon");
		}

		int secondColon = time.indexOf(':', firstColon+1);
		if (secondColon == -1) {
			throw new NumberFormatException("Unrecognized time format second colon");
		}
		
		// Interpret everything up to the first colon as the hour
		int hours = Integer.valueOf(time.substring(0, firstColon));
		// Interpret everything between the two colons as the minute
		int minutes = Integer.valueOf(time.substring(firstColon+1, secondColon));
		// Interpret the two characters after the second colon as the seconds
		int seconds = Integer.valueOf(time.substring(secondColon+1, secondColon+3));
		
		// Adjust hours if 'pm' specified
		if (time.contains("pm")) {
			hours += 12;
		}
		
		// Range check the values
		if ((hours < MIN_HRS || hours > MAX_HRS) ||
			(minutes < MIN_MINS || minutes > MAX_MINS) ||
			(seconds < MIN_SECS || seconds > MAX_SECS)) {
				throw new IllegalArgumentException("Unacceptable time specified");
		}

		// Calculate number of seconds since midnight
		return (((hours * MINS_PER_HR) + minutes) * SECS_PER_MIN) + seconds;
	}
	
	private void printHour()
	{
		System.out.print(parseTimeToSeconds("12:12:12"));
	}
}
