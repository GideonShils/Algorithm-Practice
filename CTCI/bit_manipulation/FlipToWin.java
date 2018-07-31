// You have an integer and can flip exactly one bit from 0 to 1.
// Write code to create the longest possible sequence of 1s

import java.util.*;

public class FlipToWin {
    // 
	public static int flip(int n) {
        int max = 1;
        int prevSeq = 0;
        int currSeq = 0;

        // Check each bit, shifting one by one
        while (n != 0) {
            // If bit is 1
            if ((n & 1) == 1) {
                currSeq++;
            }

            // If bit is 0
            else {
                // If next bit is also 0
                if ((n & 2) == 0) {
                    prevSeq = 0;
                } 
                // If next bit is 1
                else {
                    prevSeq = currSeq;
                }

                currSeq = 0;
            }

            if (prevSeq + currSeq > max) {
                max = prevSeq + currSeq;
            }
            
            n = n >>> 1;
        }

        return max + 1;
	}

    // Driver
	public static void main(String args[]) {
        int n = 1775;
        System.out.println(flip(n));
    }
}