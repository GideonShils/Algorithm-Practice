// You are given two 32-bit numbers, N and M, and two bit positions, i and j.
// Write a method to insert M into N such that M starts at bit j and ends at bit i.
// You can assume that the bits j through i have enough space to fit all of M.
// That is, if M = 10011, you can assume that there are at least 5 bits between j and i.
// You would not, for example, have j = 3 and i = 2, because M could not fully fit 
// between bit 3 and bit 2.
//
// ex.
// INPUT:  N = 10000000000, M = 10011, i = 2, j = 6
// OUTPUT: N = 10001001100

import java.util.*;

public class Insertion {
    // Create mask of 0s (e.g. 1111000001111), clear the 0 bits of M, insert shifted N
	public static int insert(int n, int m, int i, int j) {
        // Left shift M by i
        int shift = m << i;

        // Left side of mask: 1s left shifted j+1
        int leftOnes = (~0) << (j + 1);

        // Right side of mask: 1 left shifted i, minus 1 to fill in right 0s
        int rightOnes = (1 << i) - 1;

        // Create mask
        int mask = leftOnes | rightOnes;

        // Clear section of N using mask
        int clear = n & mask;

        // Insert shifted M into N
        int end = clear | shift;

        return end;
	}

    // Driver
	public static void main(String args[]) {
        int N = Integer.parseInt("10000000000", 2);
        int M = Integer.parseInt("10011", 2);
        int i = 2;
        int j = 6;

        System.out.println(Integer.toBinaryString(insert(N, M, i, j)));
    }
}