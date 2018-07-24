// T1 and T2 are two very large binary trees with T1 much bigger than T2.
// Create an algorithm to determine if T2 is a subtree of T1

import java.util.*;

public class CheckSubtree {
    // Option 1: pre order traversal, check substring
	public static boolean checkSubtree(Node t1, Node t2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        // Get preorder traversals
        traverse(t1, s1);
        traverse(t2, s2);

        // Check for substring
        if (s1.toString().contains(s2.toString())) {
            return true;
        } else {
            return false;
        }
    }

    // Preorder traversal
    public static void traverse(Node root, StringBuilder s) {
        if (root == null) {
            s.append('/');
        } else {
            s.append(Integer.toString(root.data));
            traverse(root.left, s);
            traverse(root.right, s);
        }
    }

    // Driver
	public static void main(String args[]) {
        /*
                       5                    10 
                     /   \                 /  \
                    /     \               9   11
                   2       7 
                  / \     / \
                 1   3   6   8
                      \       \
                       4       10
                              /  \
                             9    11
        */

        // T1
        Node root1 = new Node(5);
        root1.left = new Node(2);
        root1.left.left = new Node(1);
        root1.left.right = new Node(3);
        root1.left.right.right = new Node(4);
        root1.right = new Node(7);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);
        root1.right.right.right = new Node(10);
        root1.right.right.right.left = new Node(9);
        root1.right.right.right.right = new Node(11);

        // T2
        Node root2 = new Node(10);
        root2.left = new Node(9);
        root2.right = new Node(11);

        if (checkSubtree(root1, root2)) {
            System.out.println("t2 is subtree of t1");
        } else {
            System.out.println("t2 is not a subtree of t1");
        }
    }
    
    // Node class
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            data = d;
        }
    }
}