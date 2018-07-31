// Given a real number between 0 and 1, print the binary representation.
// If it can't be represented in 32 bits, return "ERROR."
//
// Clarification: We're not using IEEE 754 here, we're simply looking for binary
// representation in standard decimal form:
// i.e. .1010

import java.util.*;

public class BinaryToString {
    // Check each digit by left shifting one and comparing to 1
	public static String bToStr(double n) {
        if (n <= 0 || n >= 1) {
            return "ERROR.";
        }

        StringBuilder str = new StringBuilder(".");

        while (n > 0) {
            // If can't fit in 32 bits, return error
            if (str.length() > 32) {
                return "ERROR";
            }
            
            // Left shifting 1 (equivelent to *2)
            n *= 2;
            
            // If >= 1, bit was a 1
            if (n >= 1) {
                str.append("1");
                n -= 1;
            }
            // Otherwise, bit was a 0
            else {
                str.append("0");
            }
        }

        return str.toString();
	}

    // Driver
	public static void main(String args[]) {
        double n = 0.72;
        System.out.println(bToStr(n));
    }
}