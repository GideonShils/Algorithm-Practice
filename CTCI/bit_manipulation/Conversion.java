// Determine the number of bits that must be flipped to
// convert integer A to integer B

import java.util.*;

public class Conversion {
    // Count number of bits that are different
	public static int numFlips(int a, int b) {
        int aLow = 0;
        int bLow = 0;
        int count = 0;
        // Iterate until both numbers are 0
        while (a > 0 || b > 0) {
            // Get lowest bits
            aLow = a & 1;
            bLow = b & 1;

            // Compare bits
            if (aLow != bLow) {
                count++;
            }

            // Shift to next bits
            a >>= 1;
            b >>= 1;
        }

        return count;
    }
    
    // Similar but simpler way
    public static int numFlips2(int a, int b) {
        // Get the xor of a and b
        int c = a ^ b;
        int count = 0;

        // Count number of 1 bits in xor
        while (c != 0) {
            if ((c & 1) == 1) {
                count++;
            }
            c >>>= 1;
        }
        return count;
    }

    // Driver
	public static void main(String args[]) {
        System.out.println("First method: " + numFlips(29, 15));

        System.out.println("Second method: " + numFlips2(29, 15));
    }
}