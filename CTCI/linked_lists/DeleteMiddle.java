// Delete node given only access to that node
import java.util.*;

public class DeleteMiddle {
    // Put two pointers k apart. Move at same time until further is at end
	public static void deleteMiddle(Node toDel) {
        toDel.data = toDel.next.data;
        toDel.next = toDel.next.next;

        return;
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

        Node toDel = head.next.next.next.next;

        printList(head);
        deleteMiddle(toDel);
        printList(head);
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