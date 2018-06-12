// Return the Kth to last element in a singly linked list
// Assumes k cant be 0 (1 is end, 2 is 2nd to last, etc)
import java.util.*;

public class KthToLast {
    // Put two pointers k apart. Move at same time until further is at end
	public static Node kthToLast(Node head, int k) {
        Node further = head;
        Node closer = head;
        for (int i = 0; i < k-1; i++) {
            further = further.next;
        }
        
        // Move further until end of list
        while (further.next != null) {
            further = further.next;
            closer = closer.next;
        }

        return closer;
	}

    // Driver
	public static void main(String args[]) {
        // 1->3->1->4->3
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(1);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(5);

        printList(head);
        Node k = kthToLast(head, 4);
        System.out.println(k.data);
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
    }
}