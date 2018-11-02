// Return all subsets of a given set
import java.util.*;

public class PowerSet {

    public static ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;
        
        // If at end, add the empty subset
        if (index == set.size()) {
            allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(new ArrayList<Integer>());
        }
        // Otherwise, get subsets of all next indices, and add current index to each one
        else {
            allSubsets = powerSet(set, index + 1);
            ArrayList<ArrayList<Integer>> newSets = new ArrayList<>();

            for (ArrayList<Integer> subset : allSubsets) {
                ArrayList<Integer> newSet = new ArrayList<>();
                newSet.addAll(subset);
                newSet.add(set.get(index));
                newSets.add(newSet);
            }
            allSubsets.addAll(newSets);
        }

        return allSubsets;
    }

    // Driver
    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        ArrayList<ArrayList<Integer>> subsets = powerSet(set, 0);
        
        for (ArrayList<Integer> subset : subsets) {
            StringBuilder str = new StringBuilder();

            str.append("{");
            for (Integer i : subset) {
                str.append(i + ", ");
            }
            str.append("}");
            System.out.println(str.toString());
        }
    }
}