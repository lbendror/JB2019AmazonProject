package JB2019AmazonProject.JB2019AmazonProject.infra.reports;

import java.text.SimpleDateFormat;

public class ConsoleReporter {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss: ");
	
	public static void report(String message) {
		
		message = dateFormat.format(System.currentTimeMillis()) + message;
		System.out.println(message);
	}
}
