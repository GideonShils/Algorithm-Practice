// Sum two numbers represented by linked lists
import java.util.*;

public class SumLists {
	public static Node sumReverse(Node list1, Node list2) {
        Node newHead = new Node();
        Node lastNode = newHead;
        boolean first = true;
        int carry = 0;
        // Iterate through both lists until we hit end of longer list
        while (list1 != null || list2 != null) {
            int sum;
            if (list1 != null && list2 != null) {
                sum = list1.data + list2.data + carry;
            } else if (list1 != null && list2 == null) {
                sum = list1.data + carry;
            } else {
                sum = list2.data + carry;
            }
            
            Node newNode = new Node((sum % 10));

            if (sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }

            // Special case for first node
            if (first) {
                newHead = newNode;
                first = false;
            } else {
                lastNode.next = newNode;
            }

            lastNode = newNode;

            // Move to next nodes
            if (list1 != null) {
                list1 = list1.next;
            }

            if (list2 != null) {
                list2 = list2.next;
            }
        }

        return newHead;
	}

    // Driver
	public static void main(String args[]) {
        // 534,131 (reverse)
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(3);
        head1.next.next.next.next.next = new Node(5);

        // 895 (reverse)
        Node head2 = new Node(5);
        head2.next = new Node(9);
        head2.next.next = new Node(8);

        printList(sumReverse(head1, head2)); // 535,026
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