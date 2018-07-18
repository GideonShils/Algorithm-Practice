// Write an algorithm to find the next node (in-order successor) of a given
// node in a tree
//
// Assume you are given access to the parent node

import java.util.*;

public class Successor {
    // 
	public static Node getSuccessor(Node root) {
        if (root == null) {
            return null;
        }

        // Leaf
        if (root.left == null && root.right == null) {
            // If its a left child, next is parent
            if (root == root.parent.left) {
                return root.parent;
            }
            // If its a right child, next is first parent
            // in chian who leads to left child
            if (root == root.parent.right) {
                Node parentNode = root.parent;
                while (parentNode.right == root) {
                    root = parentNode;
                    parentNode = parentNode.parent;
                }
                return parentNode;
            }
        }

        // Inner node with no right node (end of tree)
        if (root.right == null) {
            return null;
        }

        // Inner node with right node
        Node currNode = root.right;
        while (currNode.left != null) {
            currNode = currNode.right;
        }
        return currNode;
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
        root.left.parent = root;

        root.left.left = new Node(1);
        root.left.left.parent = root.left;

        root.left.right = new Node(3);
        root.left.right.parent = root.left;

        root.left.right.right = new Node(4);
        root.left.right.right.parent = root.left.right;

        root.right = new Node(7);
        root.right.parent = root;

        root.right.left = new Node(6);
        root.right.left.parent = root.right;

        root.right.right = new Node(8);
        root.right.right.parent = root.right;

        root.right.right.right = new Node(9);
        root.right.right.right.parent = root.right.right;

        // next after 1 should be 2 
        System.out.println(getSuccessor(root.left.right).data);
    }
    
    // Node class
    static class Node {
        int data;
        Node parent;
        Node left;
        Node right;

        public Node(int d) {
            data = d;
        }
    }
}