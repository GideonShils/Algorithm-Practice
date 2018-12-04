// Given two arrays, find the two values with the smallest difference
// and return the difference

import java.util.*;

public class SmallestDifference {
    
    public static int smallestDiff(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int aIndex = 0;
        int bIndex = 0;

        int minDiff = Integer.MAX_VALUE;

        while (aIndex < a.length && bIndex < b.length) {
            int diff = Math.abs(a[aIndex] - b[bIndex]);
            if (diff < minDiff) {
                minDiff = diff;
            }

            if (a[aIndex] < b[bIndex]) {
                aIndex++;
            } else {
                bIndex++;
            }
        }

        return minDiff;
    }

    // Driver
    public static void main(String[] args) {
        int[] a = {1, 3, 15, 11, 2};
        int[] b = {23, 127, 235, 19, 8};

        System.out.println("Smallest diff: " + smallestDiff(a, b));

    }
}