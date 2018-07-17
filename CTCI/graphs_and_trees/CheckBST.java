// Check if a binary tree is a binary search tree
// 
// Define bst as everything in left subtree <= root and 
// everything in right subtree > root

import java.util.*;

public class CheckBST {
    // Ensure root nodes are >= min and < max
	public static boolean checkBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.data > min && root.data <= max) {
            if (checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max)) {
                return true;
            }
        }

        return false;
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

        if (checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("BST");
        } else {
            System.out.println("not BST");
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