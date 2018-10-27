// A child can run up n stairs 1, 2, or 3 at a time
// Return the count of all possible ways the child can run up the stairs
import java.util.*;

public class TripleStep {

    // Top down
    public static int tripleStep(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = tripleStep(n - 1, memo) + tripleStep(n - 2, memo) + tripleStep(n-3, memo);
            return memo[n];
        }
    }

    // Bottom up
    public static int tripleStep(int n) {
        int[] memo = new int[n + 1];

        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 2;
        
        for (int i = 3; i < memo.length; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }

        return memo[n];
    }

    // Driver
    public static void main(String[] args) {
        int n = 10;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println("Ways to run up " + n + " steps: " + tripleStep(n, memo));
    }
}