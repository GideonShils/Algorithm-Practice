// Return the Node of intersection
import java.util.*;

public class Intersection {
	public static Node getIntersection(Node head1, Node head2) {
        Node currNode1 = head1;
        Node currNode2 = head2;
        int length1 = 1;
        int length2 = 1;

        // Get lengths of each list
        while (currNode1.next != null) {
            length1++;
            currNode1 = currNode1.next;
        }

        while (currNode2.next != null ) {
            length2++;
            currNode2 = currNode2.next;
        }

        // If last nodes are same, there is intersection
        if (currNode1 == currNode2) {
            int lengthDiff = Math.abs(length1 - length2);

            // Go to point where each list has same length
            if (length1 > length2) {
                for (int i = 0; i < lengthDiff; i++) {
                    head1 = head1.next;
                }
            } else if (length1 < length2) {
                for (int i = 0; i < lengthDiff; i++) {
                    head2 = head2.next;
                }
            }

            // Iterate until we find match
            while (head1.next != null) {
              if (head1 == head2) {
                  return head1;
              }  
              head1 = head1.next;
              head2 = head2.next;
            }
            return null;
            
        } else {
            return null;
        }
	}

    // Driver
	public static void main(String args[]) {
        // 1->2->3->4->5
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        // 9->8->3->4->5
        Node head2 = new Node(9);
        head2.next = new Node(8);
        head2.next.next = head1.next.next;
        head2.next.next.next = head1.next.next.next;
        head2.next.next.next.next = head1.next.next.next.next;

        System.out.println(getIntersection(head1, head2).data);
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