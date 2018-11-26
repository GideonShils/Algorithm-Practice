// Design an algorithm to find all pairs of integers in an array which sum to a target value
import java.util.*;

public class PairsWithSum {

    public static class Pair {
        int val1;
        int val2;

        public Pair(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
    }
    
    public static List<Pair> pairsWithSums(int[] arr, int target) {
        List<Pair> pairs = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        // Make frequency map
        for (int i = 0; i < arr.length; i++) {
            int comp = target - arr[i];
            if (map.containsKey(comp)) {
                // If map contains complement and freq is > 0,
                // add pair and decrement freq
                int freq = map.get(comp);
                if (freq > 0) {
                    map.put(target - arr[i], freq - 1);
                    pairs.add(new Pair(arr[i], comp));
                }
            }
            // If comp not in map, add curr val
            else {
                if (map.containsKey(arr[i])) {
                    map.put(arr[i], map.get(arr[i]) + 1);
                } else {
                    map.put(arr[i], 1);
                }

            }
        }

        return pairs;
    }

    // Driver
    public static void main(String[] args) {
        int[] arr = {0, 3, 2, 2, 5, -1, 8, 3, 1};
        int target = 4;
        List<Pair> list = pairsWithSums(arr, target);
        
        for (Pair p : list) {
            System.out.println("(" + p.val1 + ", " + p.val2 + ")");
        }
    }
}