// Check if a linked list is a palindrome
import java.util.*;

public class Palindrome {
    // We could create a new reversed list, but this takes more space than a simple array
	public static boolean isPalindrome(Node startNode) {
        // Get length of list
        Node endNode = startNode;
        int numNodes = 1;
        while (endNode.next != null) {
            numNodes++;
            endNode = endNode.next;
        }

        // Add data to array
        int[] list = new int[numNodes];
        for (int i = 0; i < numNodes; i++) {
            list[i] = startNode.data;
            startNode = startNode.next;
        }

        // Compare data moving from ends to center
        for (int i = 0; i < numNodes/2; i++) {
            if (list[i] != list[numNodes-1-i]) {
                return false;
            }
        }

        return true;

	}

    // Driver
	public static void main(String args[]) {
        // 5->3->4->3->5
        Node head = new Node(5);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(5);

        if (isPalindrome(head)) {
            System.out.println("Is palindrome");
        } else {
            System.out.println("Is not palindrome");
        }
    }

    // Helper method
    public static void printList(Node currNode) {
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.println();
    }
    
    // Node class
    static class Node {
        Node next = null;
        int data;
        public Node(int d) {
            data = d;
        }

        public Node() {
        }
    }
}