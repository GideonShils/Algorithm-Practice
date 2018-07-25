// You're implementing a binary tree class with insert, delete and getRandomNode.
// getRandomNode should have equal chance of returning all nodes.

// Only includes insert and getRandomNode for simplicity. Delete would need to
// include normal delete and decrementSize as we recurse

import java.util.*;

public class RandomNode {
    // BinaryTree class
    static class BinaryTree {
        Node root;
        boolean empty;

        public BinaryTree() {
            empty = true;
            root = null;
        }

        // Insert data
        public void insert(int data) {
            if (empty) {
                root = new Node(data);
                empty = false;
            } else {
                insert(data, root);
            }
        }

        // Insertion recrusive function
        public void insert(int data, Node root) {
            root.incrementSize();
            if (data <= root.data) {
                if (root.left == null) {
                    root.left = new Node(data);
                } else {
                    insert(data, root.left);
                }
            } else {
                if (root.right == null) {
                    root.right = new Node(data);
                } else {
                    insert(data, root.right);
                }
            }
        }

        // Get random node
        public Node getRandomNode() {
            Random rand = new Random();

            return getRandomNode(root, rand);
        }

        // Get random node recursive function
        public Node getRandomNode(Node root, Random rand) {
            if (root == null) {
                return null;
            }

            // Generate random number between 0 and n (num child nodes) + 1
            int r = rand.nextInt(root.size + 1);

            // Calculate num nodes on left side
            int leftSize = 0;
            if (root.left != null) {
                leftSize = root.left.size;
            }

            // 1/n chance of root
            if (r == 0) {
                return root;
            } 
            // leftSize/n chance of left
            else if (r > 0 && r <= leftSize + 1) {
                return getRandomNode(root.left, rand);
            } 
            // rightSize/n chance of right
            else {
                return getRandomNode(root.right, rand);
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
                       4       10
                              /  \
                             9    11
        */

        BinaryTree tree = new BinaryTree();

        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        tree.insert(9);
        tree.insert(11);

        System.out.println("Random node: " + tree.getRandomNode().data);
    }
    
    // Node class
    static class Node {
        int data;
        Node left;
        Node right;
        int size; // number in subtree

        public Node(int d) {
            data = d;
            size = 0;
        }

        public void incrementSize() {
            size++;
        }
    }
}