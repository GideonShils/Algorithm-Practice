// Given an array and a target, return the indices of the two
// numbers that add to the target

import java.util.*;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] returnArr = {i, map.get(target - nums[i])};
                return returnArr;
            } else {
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], i);
                }
            }
        }
        
        int[] returnArr = {-1, -1};
        return returnArr;
    }

	public static void main(String args[]) {
        int[] arr = {2, 7, 11, 15};
        int[] results = twoSum(arr, 9);
        System.out.println(arr[results[0]] + " at index " + results[0]);
        System.out.println(arr[results[1]] + " at index " + results[1]);
	}
}