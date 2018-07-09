// Get the starting node of a loop in a linked list
import java.util.*;

public class LoopDetection {
    
	public static Node getLoop(Node head) {
        Node slow = head;
        Node fast = head.next;

        if (slow == fast) {
            return slow;
        }

        // Find meeting point
        while (true) {
            System.out.println(slow.data);
            System.out.println(fast.data);
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        // Move slow to head and move till meet again
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
	}

    // Driver
	public static void main(String args[]) {
        /* 1->2->3->4->5-|
        /     ^          |
        /     |          |
        /     ------------  */
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next;

        System.out.println(getLoop(head).data);
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