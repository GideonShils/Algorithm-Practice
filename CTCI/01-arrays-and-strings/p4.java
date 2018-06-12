// Check if a string is a permutation of a palindrome.

import java.util.*;

public class p4 {
	// To be a palindrome, must either have even num of every char and even length,
	// or odd length with odd num of one character
	static boolean isPalPerm (String str) {
		// Build table of counts
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		// Ignore spaces
		int numSpaces = map.get(' ');
		map.remove(' '); // Remove spaces

		// Determine number of odd count characters
		int oddCount = 0;
		for (int i : map.values()) {
			if (i % 2 != 0) {
				oddCount++;
			}
		}

		// If even length and all even counts, true
		if ((str.length() - numSpaces) % 2 == 0) {
			if (oddCount == 0) {
				return true;
			}
		} 
		// If odd length and 1 odd count, true
		else {
			if (oddCount == 1) {
				return true;
			}
		}
		// Otherwise false
		return false;
	}

	public static void main(String args[]) {
		String str = "a b u tttu ba";

		if (isPalPerm(str)) {
			System.out.println("Is palindrome permutation");
		} else {
			System.out.println("Isn't palindrome permutation");
		}
	}
}