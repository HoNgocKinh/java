package info.kinhho.karaoke_management.assistants;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
	
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm O");
	
	public static String format(ZonedDateTime dateTime) {
		
		return dateTime.format(formatter);
	}
	
	public static String format(ZonedDateTime dateTime, String formatPattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
		return dateTime.format(formatter);
	}
}
