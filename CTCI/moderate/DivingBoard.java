// You're trying to build a diving board using short and long planks
// Given two integers representing short and long plank lengths,
// return a list of all possible board lengths using k boards

import java.util.*;

public class DivingBoard {
    
    public static Set<Integer> divingBoard(int small, int large, int k) {
        Set<Integer> lengths = new HashSet<>();
        Set<String> cache = new HashSet<>();
        divingBoard(small, large, k, lengths, 0, cache);

        return lengths;
    }
    
    public static void divingBoard(int small, int large, int k, Set<Integer> lengths, 
    int length, Set<String> cache) {
        String key = "currLen:" + length + "r emaining:" + k;

        if (cache.contains(key)) {
            return;
        }

        if (k == 0) {
            lengths.add(length);
            return;
        }

        divingBoard(small, large, k - 1, lengths, length + small, cache);
        divingBoard(small, large, k - 1, lengths, length + large, cache);

        cache.add(key);
    }
    // Driver
    public static void main(String[] args) {
        Set<Integer> lengths = divingBoard(2, 4, 8);

        for (int i : lengths) {
            System.out.println(i);
        }
    }
}