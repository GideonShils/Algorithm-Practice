// Given a binary tree, design an algorithm which creates a linked list of all nodes at each depth
// (d linked lists for tree of depth d)
import java.util.*;

public class ListDepths {
    // Returns arraylist of linkedlists
	public static ArrayList<LinkedList<Node>> getDepths(Node root) {
        ArrayList<LinkedList<Node>> starts = new ArrayList<>();
        LinkedList<Node> currLevel = new LinkedList<Node>();

        if (root != null) {
            currLevel.add(root);
        }

        // Modified BFS: does level order traversal adding children to LL
        while(currLevel.size() > 0) {
            LinkedList<Node> oldLevel = currLevel;
            currLevel = new LinkedList<Node>();

            for (Node n : oldLevel) {
                if (n.left != null) {
                    currLevel.add(n.left);
                }
                if (n.right != null) {
                    currLevel.add(n.right);
                }
            }

            starts.add(oldLevel);
        }

        return starts;
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

        ArrayList<LinkedList<Node>> starts = getDepths(root);

        for (LinkedList<Node> l : starts) {
            for (Node n : l) {
                System.out.print(n.data + " ");
            }
            System.out.println();
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