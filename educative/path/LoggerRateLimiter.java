import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

	private int limit;
	private Map<String, Integer> requests;

	LoggerRateLimiter(int limit) {
		this.limit = limit;
		this.requests = new HashMap<>();
	}

	boolean makeDecision(int time, String message) {
		if (!requests.containsKey(message)) {
			requests.put(message, time);
			return true;
		}

		if (time - requests.get(message) >= limit) {
			requests.put(message, time);
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int[] times = { 1, 5, 6, 7, 15 };
		String[] messages = {
				"good morning",
				"hello world",
				"good morning",
				"good morning",
				"hello world"
		};
		var logger = new LoggerRateLimiter(7);
		for (int i = 0; i < messages.length; i++) {
			System.out.println("""
					Message: %s, Time: %d, Decission: %s
					""".formatted(messages[i], times[i],
					logger.makeDecision(times[i], messages[i])));
		}
	}
}
