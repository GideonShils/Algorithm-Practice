// Given a .isSubstring method, decide whether a word is a rotation of another,
// using only one call to .isSubstring

// This solution is more compled than the official in CTCI, but it has the same
// runtime of O(N)

import java.util.*;

public class p9 {
	// In this case, we'll use .contains instead of a custom .isSubstring
	static boolean isRotation(String str1, String str2) {
		// Ensure same length
		if (str1.length() != str2.length()) {
			return false;
		}
		
		// Search for first char of str1 in str2
		int i = 0;
		int j = 0;
		int begin = 0;
		boolean foundMatch = false;
		while (j < str2.length()) {
			// If not found, check next char of str2
			if (str1.charAt(i) != str2.charAt(j)) {
				i = 0;
				j++;
				foundMatch = false;
				continue;
			}
			// If found, check rest of match to end of str2
			if (str1.charAt(i) == str2.charAt(j)) {
				// If its start of match, mark begin index
				if (i == 0) {
					begin = j;
					foundMatch = true;
				}

				i++;
				j++;
			}
		}
		System.out.println(begin);

		// Check if rest of str2 is substring of str1
		if (str1.contains(str2.substring(0,begin)) && foundMatch) {
			return true;
		} else {
			return false;
		}
	}

	// Simler solution
	static boolean simpler(String str1, String str2) {
		if (str1.length() == 0 || str2.length() != str1.length()) {
			return false;
		}

		String str1str1 = str1 + str1;
		if (str1str1.contains(str2)) {
			return true;
		}

		return false;
	}

	public static void main(String args[]) {
		String str1 = "rwaterbottle";
		String str2 = "waterbottler";

		if (simpler(str1, str2)) {
			System.out.println("Is rotation");
		} else {
			System.out.println("Isn't rotation");
		}
	}
}