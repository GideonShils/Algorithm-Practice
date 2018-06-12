// Check if the characters in a string are unique

import java.util.*;

public class p1 {
	/* Simple hashset implementation. - Runs in O(N) time and takes O(N) space.
	/
	/  If the number of possible characters was constrained (e.g. ASCII), we could
	/  optimize to O(1) space by using either a boolean array or bit manipulation.
	*/
	static boolean uniqueCharsHash (String str) {
		if (str == null) {
			return true;
		}

		HashSet<Character> found = new HashSet<Character>();

		// Iterate over string
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			// If character has already been seen, return false. Else, add to set
			if (found.contains(c)) {
				return false;
			} else {
				found.add(c);
			}
		}

		return true;
	}

	// Example implementation of bit maniuplation. Assumes ASCII values a-z
	static boolean uniqueCharsBit (String str) {
		if (str == null) {
			return true;
		}
		// Set vector to 32 0 bits. Each bit location represents one character a-z
		int vector = 0;

		for (int i = 0; i < str.length(); i++) {
			// Get bit position (0 - 26)
			int c = str.charAt(i) - 'a';

			// Check if the c'th bit is 1.
			// If it is, return false. Else, make it 1
			if (((1 << c) & vector) > 0) {
				return false;
			} else {
				vector = vector | (1 << c);
			}
		}

		return true;
	}

	public static void main(String args[]) {
		String ex = "tester";

		if (uniqueCharsBit(ex)) {
			System.out.println("All unique");
		} else {
			System.out.println("Found dups");
		}

		if (uniqueCharsBit(ex)) {
			System.out.println("All unique");
		} else {
			System.out.println("Found dups");
		}
	}
}