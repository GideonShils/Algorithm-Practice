// Check if a string is a permutation of another string

import java.util.*;

public class p2 {
	// Assume ASCII. If unicode is used, we may want to use a 
	// hashmap instead to account for the high variability of characters
	static boolean isPermutation (String str1, String str2) {
		if (str1 == null || str2 == null) {
			return false;
		}
		// Initialize 0 filled array
		int[] counts = new int[128];

		// Increment index of each letter by 1
		for (int i = 0; i < str1.length(); i++) {
			counts[str1.charAt(i) - 'A'] += 1;
		}

		// Decrement index of each letter by 1
		for (int i = 0; i < str2.length(); i++) {
			counts[str2.charAt(i) - 'A'] -= 1;

			// If below 0, doesnt have same chars
			if (counts[str2.charAt(i) - 'A'] < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		String str1 = "tester";
		String str2 = "setter";

		if (isPermutation(str1, str2)) {
			System.out.println("is permutation");
		} else {
			System.out.println("isn't permutation");
		}
	}
}