package tema6;

import java.util.HashMap;
import java.util.Map;

/*
 * This class is a String.util class
 * which allows two modification to be made to a String
 */

public class StringUtility {
	public final static Map<String, Integer> map = new HashMap<String, Integer>();

	// the hashmap is built in a static block.
	static {
		String[] str = { "zero", "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine" };
		for (int i = 0; i < str.length; i++) {
			map.put(str[i], i);
		}

	}

	// this method removes al the free space between characters in a certain
	// String
	public String removeFreeSpace(String stri) {
		stri = stri.replaceAll("\\s", "");
		return stri;
	}

	// this method transforms all the Digit Words from 0 to 9 into Digits
	public String modifyString(String string) {
		for (String stringNr : map.keySet()) {
			string = replaceNumbers(string, stringNr);
		}
		return string;
	}

	private String replaceNumbers(String original, String patern) {
		String[] words = original.split(" ");
		String ret = "";
		int i = 0;
		for (String word : words) {
			boolean isEqual = word.equalsIgnoreCase(patern);
			if (isEqual) {
				ret += map.get(patern);
			} else {
				ret += word;
			}
			if (i < words.length - 1) {
				ret += " ";
			}
			i++;
		}
		return ret;
	}

}
