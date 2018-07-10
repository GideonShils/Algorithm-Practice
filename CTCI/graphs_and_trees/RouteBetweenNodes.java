// Given a directed graph, decide if there is a route between two nodes
import java.util.*;

public class RouteBetweenNodes {
    // Uses BFS to determine if there is a route
	public static boolean findRoute(Node start, Node end) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(start);
        while(!queue.isEmpty()) {
            Node currNode = queue.remove();
            currNode.visited = true;
            if (currNode == end) {
                return true;
            }
            for (Node n : currNode.children) {
                if (!n.visited) {
                    queue.add(n);
                }
            }
        }
        return false;
	}

    // Driver
	public static void main(String args[]) {
        /* 
        
        1->2->3
           ^  |
           |  |
           4->5        
        
        */
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        one.addChild(two);
        two.addChild(three);
        three.addChild(five);
        four.addChild(two);
        four.addChild(five);

        if (findRoute(three, five)) {
            System.out.println("Found route");
        } else {
            System.out.println("No route found");
        }
    }
    
    // Node class
    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<Node>();
        boolean visited;

        public Node(int d) {
            data = d;
            visited = false;
        }

        public void addChild(Node n) {
            children.add(n);
        }
    }
}