// Swap a number in place without temporary variables

import java.util.*;

public class Swap {

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    //        diff
    // 0----x-------y
    public static void swap(Pair p) {
        // Set x to difference between x and y
        p.x = p.y - p.x;

        // Set y to y minus difference
        p.y = p.y - p.x;

        // Set x to y plus difference
        p.x = p.y + p.x;
    }

    // Driver
    public static void main(String[] args) {
        Pair p = new Pair(2, 7);
        System.out.println("Before: x=" + p.x + " y=" + p.y);
        swap(p);
        System.out.println("After: x=" + p.x + " y=" + p.y);
    }
}