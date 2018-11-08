// Generate all primes up to a given value

import java.util.*;

public class GeneratePrimes {
    // Use the sieve of erastothenes
	static List<Integer> generatePrimes(int max) {
        boolean[] list = new boolean[max + 1];
        Arrays.fill(list, true);

        int currPrime = 2;

        while(currPrime <= Math.sqrt(max)) {
            crossOff(currPrime, list);
            currPrime = getNext(currPrime, list);
        }

        List<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i < list.length; i++) {
            if (list[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
    
    static void crossOff(int prime, boolean[] list) {
        for (int i = prime * prime; i <= list.length; i += prime) {
            list[i] = false;
        }
    }

    static int getNext(int currPrime, boolean[] list) {
        for (int i = currPrime + 1; i <= list.length; i++) {
            if (list[i] == true) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }

	public static void main(String args[]) {
        int max = 100;
        List<Integer> primes = generatePrimes(max);
        for (Integer i : primes) {
            System.out.print(i + ", ");
        }
        System.out.println();
	}
}