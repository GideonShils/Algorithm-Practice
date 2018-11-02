// A magic index of array A is defined as an index where A[i] = i
// Given a sorted array of distinct integers, find a magic index if it exists
import java.util.*;

public class MagicIndex {

    public static int magicIndex(int[] arr, int start, int end) {
        if (end < start) {
            return -1;
        }
        int middle = (start + end) / 2;

        if (middle == arr[middle]) {
            return middle;
        }

        if ( middle < arr[middle]) {
                return magicIndex(arr, start, middle - 1);
        } else {
                return magicIndex(arr, middle + 1, end);
        }
    }

    // Driver
    public static void main(String[] args) {
        int[] arrDistinct = {-3, 1, 4, 5, 9, 20};
        
        System.out.println("Magic index: " + magicIndex(sorted, 0, sorted.length - 1));
    }
}