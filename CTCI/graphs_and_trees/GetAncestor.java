// Write an algorithm to find the closest common ancestor between two
// nodes in a binary tree (not necessarily BST)
// Avoid storing additional nodes in a data structure
// - if this were possible, we could simply store paths to both, then traverse until we hit a mismatch

// Assume nodes don't have links to their parents

import java.util.*;

public class GetAncestor {
    // Find the lowest "root" with children in its L/R subtrees
    // Works by returning non null if present in subtree, then returnign once in left and right subtree
	public static Node findAncestor(Node root, Node node1, Node node2) {
        // Null case
        if (root == null) {
            return null;
        }

        if (root == node1 || root == node2) {
            return root;
        }

        // Check left. If non null, a node is present in left subtree
        Node left = findAncestor(root.left, node1, node2);

        // Check right. If non null, a node is present in right subtree
        Node right = findAncestor(root.right, node1, node2);

        // If neither value was null, nodes are in oppsite sides and we've found ancestor
        if (left != null && right != null) {
            return root;
        } 
        
        // Otherwise, return the side that was found
        else {
            if (left != null) {
                return left;
            } else {
                return right;
            }
        }
        
	}

    // Driver
	public static void main(String args[]) {
        /* 
                       5
                     /   \
                    /     \
                   2       7 
                  / \     / \
                 1   3   6   8
                      \       \
                       4       9
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

        System.out.println(findAncestor(root, root.left.right.right, root.right.left).data);
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