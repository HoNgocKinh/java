package info.kinhho.karaoke.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateType {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("EEEEE");
	
	public static String getDateType(Date date) {
		
		String dayOfWeek = sdf.format(date);
		
		if (dayOfWeek.equalsIgnoreCase("SATURDAY") || dayOfWeek.equalsIgnoreCase("SUNDAY")) {
			return "WEEKEND";
		}

		return "NORMAL";
	}
		
}
