// 0/1 Knapsack problem. Given a list of items with given weights and values,
// return the maximum value of items that can fit in the knapsack which cna hold weight W.
import java.util.*;

public class Knapsack {

    // Top down recursive approach. For each item, return max val of whether we include it or dont
    public static int topDown(int[] weights, int[] values, int remainingWeight, int index) {
        // If no items left or no space in knapsack left, return 0
        if (index < 0 || remainingWeight == 0) {
            return 0;
        }

        // If current items weight is greater than remaining space, move to next item
        if (weights[index] > remainingWeight) {
            return topDown(weights, values, remainingWeight, index - 1);
        }

        // If we can fit the current item, return the max value of whether we include it or skip it
        int valueWithItem = values[index] + topDown(weights, values, remainingWeight - weights[index], index - 1);
        int valueWithoutItem = topDown(weights, values, remainingWeight, index - 1);
        return Math.max(valueWithItem, valueWithoutItem);
    }

    // Top down recursive approach using memoization to prevent repeated recursive calls
    public static int topDownDP(int[] weights, int[] values, int remainingWeight, int index, int[][]memo) {
        if (memo[index][remainingWeight] != -1) {
            return memo[index][remainingWeight];
        }

        // If no items left or no space in knapsack left, return 0
        if (index < 0 || remainingWeight == 0) {
            memo[index][remainingWeight] = 0;
            return memo[index][remainingWeight];
        }

        // If current items weight is greater than remaining space, move to next item
        if (weights[index] > remainingWeight) {
            memo[index][remainingWeight] = topDown(weights, values, remainingWeight, index - 1);
            return memo[index][remainingWeight];
        }

        // If we can fit the current item, return the max value of whether we include it or skip it
        int valueWithItem = values[index] + topDown(weights, values, remainingWeight - weights[index], index - 1);
        int valueWithoutItem = topDown(weights, values, remainingWeight, index - 1);
        memo[index][remainingWeight] = Math.max(valueWithItem, valueWithoutItem);
        return memo[index][remainingWeight];
    }

	public static void main(String args[]) {
        int maxWeight = 50;
        int[] itemValues = {60, 100, 120};
        int[] itemWeights = {10, 20, 30};

        int[][] memo = new int[itemValues.length][maxWeight + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        System.out.println("topDown: " + topDown(itemWeights, itemValues, maxWeight, itemValues.length - 1));
        System.out.println("topDownDP: " + topDownDP(itemWeights, itemValues, maxWeight, itemValues.length - 1, memo));
	}
}