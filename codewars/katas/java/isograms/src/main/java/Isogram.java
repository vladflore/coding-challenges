import java.util.stream.Collectors;

public class Isogram {

	/*
	An isogram is a word that has no repeating letters, consecutive or non-consecutive.
	Implement a function that determines whether a string that contains only letters is an isogram.
	Assume the empty string is an isogram.
	Ignore letter case.
	 */

	public static boolean isIsogram(String str) {
		if (str == null) {
			str = "";
		}
		return str.chars().mapToObj(c -> ("" + (char) c).toLowerCase()).collect(Collectors.toSet()).size() == str.length();
	}
}
