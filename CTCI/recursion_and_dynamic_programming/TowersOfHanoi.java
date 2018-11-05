// You have three towers and N disks of different sizes which can slide onto any tower.
// The puzzle starts with disks sorted in ascending order of size from top to bottom.
// Move the disks from the first to last tower.

// 1. Only one disk can be moved at a time
// 2. A disk is slid off the top of one tower onto another
// 3. A disk can only be placed on top of a larger disk
import java.util.*;

public class TowersOfHanoi {

    static class Tower {
        Stack<Integer> stack;

        public Tower() {
            stack = new Stack<Integer>();
        }

        public void addDisk(int i) {
            stack.push(i);
        }

        public void moveTop(Tower t) {
            t.addDisk(stack.pop());
        }

        public void move(int numToMove, Tower buffer, Tower destination) {
            if (numToMove <= 0) {
                return;
            }

            // Move n - 1 to buffer
            move(numToMove - 1, destination, buffer);
            // Move the top to destination
            moveTop(destination);
            // Move n - 1 from buffer to destination, using current as buffer
            buffer.move(numToMove - 1, this, destination);
        }

        public void printTower() {
            for (Integer disk : this.stack) {
                System.out.println(disk);
            }
            System.out.println();
        }
    }

    // Driver
    public static void main(String[] args) {
        int numDisks = 6;

        Tower one = new Tower();
        Tower two = new Tower();
        Tower three = new Tower();

        for (int i = numDisks - 1; i >= 0; i--) {
            one.addDisk(i);
        }

        // Print original towers
        System.out.println("Original:");
        System.out.println("Tower 1: ");
        one.printTower();
        System.out.println("Tower 2: ");
        two.printTower();
        System.out.println("Tower 3: ");
        three.printTower();

        // Move disks
        one.move(numDisks, two, three);

        // Print towers after move
        System.out.println("After move:");
        System.out.println("Tower 1: ");
        one.printTower();
        System.out.println("Tower 2: ");
        two.printTower();
        System.out.println("Tower 3: ");
        three.printTower();
    }
}