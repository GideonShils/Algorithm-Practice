// Given a positive integer, print the next smallest and next
// largest number that have the same number of 1 bits

// ex.
// 10010101 (149) - 4 bits
// next largest:  150 10010110
// next smalelst: 147 10010011
//

import java.util.*;

public class NextNumber {
	public static void next(int n) {
        int small = n;
        int large = n;

        /*************
         * Step 1: Larger
         * Flip first non trailing 0 bit to 1.
         * Zero out bits to the right
         * Put original number of 1s to the right (-1) at the end
         *************/

        int m = n;
        int count0 = 0; // num 0s at beginning
        int count1 = 0; // num 1s after 0s

        // Shift until 1 found
        while ((m & 1) == 0) {
            m >>= 1;
            count0++;
        }
        // Shift until 0 found
        while ((m & 1) == 1) {
            m >>= 1;
            count1++;
        }

        // Get position of first 0 bit
        int bitToFlip = count1 + count0;

        // Flip 0 bit and mask out bits to right
        int oneBit = 1;
        int mask = ~0;
        for (int i = 0; i < bitToFlip; i++) {
            oneBit <<= 1;
            mask <<= 1;
        }
        large |= oneBit;
        large &= mask;

        // Insert 1s at end
        int ones = 0;
        for (int i = 0; i < count1 - 1; i++) {
            ones <<= 1;
            ones |= 1;
        }
        large |= ones;


        /*************
        * Smaller: 
        * Flip first non trailing 1 bit
        * Zero out bits to right
        * Put original number of 1s to the right (+1) to the right of this bit
        **************/

        // Reset vars
        m = n;
        count0 = 0; // num 0s
        count1 = 0; // num 1s

         // Shift until 0 found
         while ((m & 1) == 1) {
            m >>= 1;
            count1++;
        }
        // Shift until 1 found
        while ((m & 1) == 0) {
            m >>= 1;
            count0++;
        }

        // Get bit to flip
        bitToFlip = count0 + count1;
        
        // Flip the bit
        oneBit = 1;
        oneBit <<= bitToFlip;
        oneBit = ~oneBit; 
        small &= oneBit;

        // Mask out
        mask = ~0;
        mask <<= bitToFlip;
        small &= mask;
        
        ones = 0;
        // Get number of 1s to insert (original count + 1)
        for (int i = 0; i < count1 + 1; i++ ) {
            ones <<= 1;
            ones |= 1;
        }
        
        // Shift 1s to the spot to the right of the flipped bit
        ones <<= count0 - 1;

        // Insert 1s
        small |= ones;

        System.out.println("Next smallest: " + small);
        System.out.println("Next largest: " + large);
        System.out.println();
        System.out.println("Original in binary: " + Integer.toBinaryString(n));
        System.out.println("Small in binary: " + Integer.toBinaryString(small));
        System.out.println("Large in binary: " + Integer.toBinaryString(large));
	}

    // Driver
	public static void main(String args[]) {
        next(156);
    }
}