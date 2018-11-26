// Get the frequency of a given word from a book

import java.util.*;

public class Frequency {
    
    public static Map<String, Integer> makeMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = str.split(" ");

        for (String s : words) {
            s = s.toLowerCase();
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        return map;
    }

    public static int getFreq(String str, Map<String, Integer> map) {
        return map.get(str.toLowerCase());
    }

    // Driver
    public static void main(String[] args) {
        Map<String, Integer> map = makeMap("This is a sample book. This book is very good and has some words multiple times");

        System.out.println("'This' appears " + getFreq("this", map) + " times");
        System.out.println("'Is' appears " + getFreq("IS", map) + " times");
        System.out.println("'Multiple' appears " + getFreq("MuLtiPLE", map) + " time");
    }
}