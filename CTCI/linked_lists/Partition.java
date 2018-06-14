// Partition list such that all nodes < partition are before all nodes >= partition
import java.util.*;

public class Partition {
    // Iterate through list, removing all nodes >= partition and adding them to the end
	public static Node partition(Node head, int partition) {
        // Find tail node
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        Node prevNode = null;
        Node currNode = head;
        Node firstFound = null; // Indicates the first node we moved.(so we dont repeat)

        // Iterate through.
        while (currNode.next != null && currNode != firstFound) {
            // If node >= partition, remove it and put it at the end
            if (currNode.data >= partition) {
                // If first time moving, save node
                if (firstFound == null) {
                    firstFound = currNode;
                }

                // Add node to tail
                tail.next = currNode;
                tail = currNode;

                // Remove node from curr position
                // Special case for head
                if (prevNode == null) {
                    head = currNode.next;
                } else {
                    prevNode.next = currNode.next;
                }

                // Iterate to next node
                currNode = currNode.next;

                // Chop tail to remove cycle
                tail.next = null;
            } else {
                prevNode = currNode;
                currNode = currNode.next;
            }
        }

        return head;
	}

    // Driver
	public static void main(String args[]) {
        // 1->3->1->4->3->5
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(1);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(5);

        printList(head);
        printList(partition(head, 3)); // 1->1->3->4->3->5
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