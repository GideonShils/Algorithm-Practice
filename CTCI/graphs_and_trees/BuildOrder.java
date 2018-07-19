// Given a list of projects and a list of dependencies where dependencies must be built
// before projects, return the order in which the projects cna all be built.
//
// ex:
//     projects: a, b, c, d, e, f
// dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)

import java.util.*;

public class BuildOrder {
    // Creates directed graph, then repeatedly adds nodes with
    // No incoming edges until done
	public static ArrayList<Node> getOrder(ArrayList<Node> projs, ArrayList<Pair> deps) {
        // Build dependency directed graph (add children based on list)
        // while keeping track of # of incoming edges
        // f -> a -> d -> c
        // |         ^
        // b --------|
        //
        // e
        for (Pair p : deps) {
            Node project = p.proj;
            Node dependency = p.dep;

            dependency.addChild(project);
            project.incrementIncoming();
        }

        // Create order array
        ArrayList<Node> order = new ArrayList<>();

        // Add all projects with 0 incoming edges ("roots")
        for (Node p : projs) {
            if (p.incoming == 0) {
                order.add(p);
            }
        }

        // Iterate through order array, checking children for 0 incoming edges
        for (int i = 0; i < projs.size(); i++) {
            for (Node p : order.get(i).children) {
                p.decrementIncoming();
                if (p.incoming == 0) {
                    order.add(p);
                }
            }
        }

        return order;
	}

    // Driver
	public static void main(String args[]) {
        // Create project nodes
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');

        // Create project list
        ArrayList<Node> projs = new ArrayList<>();
        projs.add(a);
        projs.add(b);
        projs.add(c);
        projs.add(d);
        projs.add(e);
        projs.add(f);

        // Create dependency list
        ArrayList<Pair> deps = new ArrayList<>();
        deps.add(new Pair(a, d));
        deps.add(new Pair(f, b));
        deps.add(new Pair(b, d));
        deps.add(new Pair(f, a));
        deps.add(new Pair(d, c));

        // Get the order
        ArrayList<Node> order = getOrder(projs, deps);

        // Print the order
        for (Node proj : order) {
            System.out.print(proj.data + " ");
        }
        System.out.println();
    }
    
    // Node class
    static class Node {
        char data;
        ArrayList<Node> children = new ArrayList<>();
        int incoming;

        public Node(char d) {
            data = d;
            incoming = 0;
        }

        public void addChild(Node c) {
            children.add(c);
        }

        public void incrementIncoming() {
            incoming++;
        }

        public void decrementIncoming() {
            incoming--;
        }
    }

    // Pair class
    static class Pair {
        Node proj;
        Node dep;

        public Pair(Node proj, Node dep) {
            this.dep = proj;
            this.proj = dep;
        }
    }
}