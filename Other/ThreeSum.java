// Given an array of integers, find all unique sets of 3
// integers that add to 0 

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            // If i is different from the previous int, proceed
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int target = 0 - nums[i];
                int low = i + 1;
                int high = nums.length - 1;

                while (low < high) {
                    int sum = nums[low] + nums[high];
                    if (sum == target) {
                        // Found set. Add to results
                        List<Integer> set = new ArrayList<>();
                        set.add(nums[i]);
                        set.add(nums[low]);
                        set.add(nums[high]);
                        results.add(set);

                        // Continue checking by finding next different high/low
                        while(low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        low++;

                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        high--;
                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return results;
    }

	public static void main(String args[]) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> results = threeSum(arr);
    
        for (List set : results) {
            System.out.print("[");
            for (int i = 0; i < set.size(); i++) {
                System.out.print(set.get(i) + ", ");
            }
            System.out.println("]");
        }
	}
}