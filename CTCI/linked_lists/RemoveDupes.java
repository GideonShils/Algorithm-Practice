// Remove duplicates from an unsorted linked list
import java.util.*;

public class RemoveDupes {
    // Add data to hash set. If already there, delete node
	public static Node removeDupes(Node head) {
        HashSet<Integer> set = new HashSet<Integer>();
        Node currNode = head;
        Node prevNode = null;

		while (currNode != null) {
            if (set.contains(currNode.data)) {
                prevNode.next = currNode.next;
            } else {
                set.add(currNode.data);
            }
            prevNode = currNode;
            currNode = currNode.next;
        }

        return head;
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
        printList(removeDupes(head));
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