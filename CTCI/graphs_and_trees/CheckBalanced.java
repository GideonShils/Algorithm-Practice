// Check if a binary tree is balanced
// Balanced is defined as heights of two subtrees of any node not differing by more than 1
import java.util.*;
import java.math.*;

public class CheckBalanced {
    
	public static int checkHeight(Node root) {
        // If no children, height of tree is 1 and balanced
        if (root.left == null && root.right == null) {
            return 1;
        } 
        // If children, height is max
        else {
            if (root.left != null && root.right == null) {
                int leftHeight = checkHeight(root.left);
                // unbalanced
                if (leftHeight > 1 || leftHeight < 0) {
                    return -1;
                } 
                // balanced
                else {
                    return leftHeight + 1;
                }
            } else if (root.left == null && root.right != null) {
                int rightHeight = checkHeight(root.right);
                // unbalanced
                if (rightHeight > 1 || rightHeight < 0) {
                    return -1;
                } else {
                    return rightHeight + 1;
                }
            } else {
                int leftHeight = checkHeight(root.left);
                int rightHeight = checkHeight(root.right);
                if (leftHeight == rightHeight || leftHeight == rightHeight + 1 || leftHeight == rightHeight - 1) {
                    return Math.max(leftHeight, rightHeight) + 1;
                } else {
                    return -1;
                }
            }
        }
	}

    // Driver
	public static void main(String args[]) {
        /* 
                       5
                     /    \
                    /      \
                   2        7 
                  / \      / \
                 1   3    6   8
                      \        \
                       4        9
        */

        Node root = new Node(5);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.left.right.right = new Node(4);
        root.right = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        root.right.right.right = new Node(9);

        if (checkHeight(root) > 0) {
            System.out.println("balanced");
        } else {
            System.out.println("unbalanced");
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