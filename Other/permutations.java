// Get all permutations of a string

import java.util.*;

public class Permutations {
    // Top down approach. Break off last char, recurse on remainder,
    // insert in all locs, merge 
	static HashSet<String> permute (String str) {
        HashSet<String> set = new HashSet<String>();
        if (str.length() == 0) {
            set.add("");
            return set;
        }

        char letter = str.charAt(str.length() - 1);
        HashSet<String> strs = permute(str.substring(0, str.length() - 1));
        for (String s : strs) {
            for (int i = 0; i <= s.length(); i++) {
                set.add(s.substring(0,i) + letter + s.substring(i));
            }
        }
        return set;
	}

	public static void main(String args[]) {
		String str = "abc";

        HashSet<String> perms = permute(str);
        
        for (String s : perms) {
            System.out.println(s);
        }
	}
}