// Write a method to compute all permutations of a string where the characters are not necessarily unique
// The resulting list should not have duplicates

import java.util.*;

public class PermutationsWithDups {

    public static List<String> permutationsWithDups(String str){
        // Create frequency hash
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        // Get permutations
        List<String> perms = new ArrayList<>();
        permutationsWithDups(map, "", perms, str.length());
        return perms;
    }

    public static void permutationsWithDups(Map<Character, Integer> map, String pre, List<String> perms, int remaining) {
        // If the length is correct, add to final list and return
        if (remaining == 0) {
            perms.add(pre);
            return;
        }
        
        // Iterate through character options and try them one at a time
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                permutationsWithDups(map, pre + c, perms, remaining - 1);
                map.put(c, count);
            }
        }
    }

    // Driver
    public static void main(String[] args) {
        String str = "abca";
        List<String> permutations = permutationsWithDups(str);
        for (String s : permutations) {
            System.out.println(s);
        }
    }
}