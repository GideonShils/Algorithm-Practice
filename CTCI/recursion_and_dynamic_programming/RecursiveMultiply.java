// Multiply tow positive integers without using the * operator. You can use addition,
// subtraction, and bit shifting. Minimize the number of operations
import java.util.*;

public class RecursiveMultiply {

    public static int multiply(int a, int b) {
        // Determine smaller and larger
        int smaller = a < b ? a : b;
        int larger = a > b ? a : b;

        // Multiply
        return multiplyHelper(smaller, larger);
    }

    public static int multiplyHelper(int smaller, int larger) {
        // If smaller 0, return 0
        if (smaller == 0) {
            return 0;
        }

        // If smaller 1, return larger
        if (smaller == 1) {
            return larger;
        }

        // Calculate half of smaller (right shift 1) and recurse to get half the size of big * small
        int s = smaller >> 1; // Set s to half of smaller
        int half1 = multiplyHelper(s, larger);
        int half2;

        // If smaller was odd, we need to calculate the other half seperately
        if (smaller % 2 == 1) {
            half2 = half1 + larger;
        }
        // If smaller was even, half 2 should equal half 1
        else {
            half2 = half1;
        }

        return half1 + half2;
    }

    // Driver
    public static void main(String[] args) {
        int a = 6;
        int b = 3;
        System.out.println(multiply(a, b));
    }
}