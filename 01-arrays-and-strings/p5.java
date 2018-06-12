// Determine if a string can be converted to another string by inserting,
// deleting, or replacing a character

import java.util.*;

public class p5 {
	
	static boolean oneAway (String str1, String str2) {
		// If lenghts diff by more than 1 chars, return false
		if (str1.length() > str2.length() + 1 || str1.length() < str2.length() - 1) {
			return false;
		}

		// Same length (replacement)
		if (str1.length() == str2.length()) {
			int numDiff = 0;
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) != str2.charAt(i)) {
					numDiff++;
					if (numDiff > 1) {
						return false;
					}
				}
			}
			return true;
		}

		// Swap so str2 is the longer one
		if (str1.length() > str2.length()) {
			String temp = str1;
			str1 = str2;
			str2 = temp;
		}

		// Check for insertion (or if we swapped, replacement)
		int i = 0;	// str1 index
		int j = 0;  // str2 index
		while (j < str2.length()) {
			if (str1.charAt(i) != str2.charAt(j)) {
				if (j > (i + 1)) {
					return false;
				} else {
					i--;
				}

			}
			j++;
			i++;
		}
		return true;
	}

	public static void main(String args[]) {
		String str1 = "spring";
		String str2 = "sring";

		if (oneAway(str1, str2)) {
			System.out.println("One away!");
		} else {
			System.out.println("Not one away");
		}
	}
}