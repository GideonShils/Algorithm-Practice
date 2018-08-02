// Flip the even and odd bits in as few operations as possible
// i.e. flip bit 0 and 1, 2 and 3, 3 and 4, etc.
// ex:
// 10100100 -> 01101000

import java.util.*;

public class PairwiseSwap {
    // Shift odds left, shift evens right, combine
	public static int swap(int x) {
        int evens = x & 0xaaaaaaaa; // Get all evens by anding with 10101010
        int odds = x & 0x55555555; // Get all odds by anding with 01010101

        // Shift evens to right
        evens >>>= 1;
        // Shift odds to left
        odds <<= 1;

        // Combine result
        return evens | odds;
    }

    // Driver
	public static void main(String args[]) {
        int x = 164;
        System.out.println("Original: " + Integer.toBinaryString(x));
        System.out.println("Swapped:  " + Integer.toBinaryString(swap(x)));
    }
}