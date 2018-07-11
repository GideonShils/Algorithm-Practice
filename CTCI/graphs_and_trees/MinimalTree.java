// Given a sorted (increasing order) array with unique integer elements,
// write an algorithm to create a binary search tree with minimal height
import java.util.*;

public class MinimalTree {
    // Make node out of middle item, then make left child middle of left, right child middle of right
	public static Node createMinimal(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int middleIndex = (start + end) / 2;

        // Create node with middle element
        Node newNode = new Node(arr[middleIndex]);

        // Add left child
        newNode.left = createMinimal(arr, start, middleIndex - 1);

        // Add right child
        newNode.right = createMinimal(arr, middleIndex + 1, end);

        return newNode;
	}

    // Driver
	public static void main(String args[]) {
        /* Want to create minimal height 
        
                       5
                     /    \
                    /      \
                   2        7 
                  / \      / \
                 1   3    6   8
                      \        \
                       4        9
        */

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Node route = createMinimal(arr, 0, arr.length-1);

        printTree(route);
    }

    // Level order traversal print
    public static void printTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            if (curr != null && !curr.visited) {
                System.out.println(curr.data);
                queue.add(curr.left);
                queue.add(curr.right);
            } 
        }
    }
    
    // Node class
    static class Node {
        int data;
        boolean visited;
        Node left;
        Node right;

        public Node(int d) {
            data = d;
            visited = false;
        }
    }
}