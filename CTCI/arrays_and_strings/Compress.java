// Compress a string using character repetition
// e.g. aaabbb = a3b3
import java.util.*;

public class Compress {
	static String compress(String str) {
		StringBuilder compressed = new StringBuilder();
		char c = str.charAt(0);
		int length = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != c | i == str.length() - 1) {
				compressed.append(c);
				if (i == str.length() - 1) {
					compressed.append(Integer.toString(length + 1));
				} else {
					compressed.append(Integer.toString(length));
				}
				c = str.charAt(i);
				length = 0;
			}
			length++;
		}

		// Only return new string if it is shorter than original
		if (compressed.length() >= str.length()) {
			return str;
		} else {
			return compressed.toString();
		}
	}

	public static void main(String args[]) {
		String str = "aaaabbccccccdddddeeeeaabb";

		System.out.println(compress(str));
	}
}