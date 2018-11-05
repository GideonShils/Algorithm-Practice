// Write a method to compute all permutations of a string of unique characters

import java.util.*;

public class PermutationsWithoutDups {

    public static List<String> permutationsWithoutDupes(String str){
        if (str == null) {
            return null;
        }

        List<String> permutations = new ArrayList<String>();
        // If single letter, add the letter and return
        if (str.length() == 1) {
            permutations.add(str);
        } 
        // Otherwise, break off the final character, get permutations of rest of letters,
        // and insert character into every location of each smaller permutation
        else {
            char c = str.charAt(str.length() - 1);
            List<String> smallerPermutes = permutationsWithoutDupes(str.substring(0, str.length() - 1));
            for (String s : smallerPermutes) {
                for (int i = 0; i <= s.length(); i++) {
                    String newString = s.substring(0, i) + c + s.substring(i);
                    permutations.add(newString);
                }
            }
        }

        return permutations;
    }

    // Driver
    public static void main(String[] args) {
        String str = "abc";
        List<String> permutations = permutationsWithoutDupes(str);
        for (String s : permutations) {
            System.out.println(s);
        }
    }
}