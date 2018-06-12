// Assuming a buffer at the end of a string, replace all spaces with "%20"

import java.util.*;

public class p3 {
	// Assumes a perfectly sized char array
	// If untrue, we can replace end with length + (num spaces * 2)
	static char[] URLify (char[] str, int length) {
		int end = str.length - 1;
		for (int i = length - 1; i > 0; i--) {
			if (str[i] == ' ') {
				str[end] = '0';
				str[end - 1] = '2';
				str[end - 2] = '%';
				end -= 3;
			} else {
				str[end] = str[i];
				end--;
			}
		}
		return str;
	}

	public static void main(String args[]) {
		String str = "this is a test      ";

		char[] chars = str.toCharArray();
		char[] ret = URLify(chars, 14);

		System.out.println(new String(ret));
	}
}