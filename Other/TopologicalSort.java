// Given a directed acyclic graph, return an ordered list such that all
// parent nodes appear before their child nodes

import java.util.*;

public class TopologicalSort {
	static List<Integer> topologicalSort(Graph g) {
        List<Integer> sorted = new ArrayList<>();

        // Generate array for number of incoming edges per vertex
        int[] incoming = new int[g.numVertices];
        for (int i = 0; i < g.numVertices; i++) {
            for (Integer j : g.adjList[i]) {
                incoming[j]++;
            }
        }

        // Create queue and add all vertices with 0 incoming edges
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < incoming.length; i++) {
            if (incoming[i] == 0) {
                queue.add(i);
            }
        }

        // Dequeue item and add to list,
        // then decrement incoming array for each outgoing edge.
        // If incoming val is 0, add that vertex to queue
        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            sorted.add(vertex);
            for (Integer i : g.adjList[vertex]) {
                incoming[i]--;
                if (incoming[i] == 0) {
                    queue.add(i);
                }
            }
        }

        return sorted;
    }

	public static void main(String args[]) {
        // Generate graph
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        // Sort
        List<Integer> sorted = topologicalSort(g);

        // Print list
        for (Integer i : sorted) {
            System.out.print(i + "->");
        }
        System.out.println();
    }
    
    public static class Graph {
        int numVertices;
        List<Integer>[] adjList;

        public Graph(int v) {
            numVertices = v;
            adjList = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adjList[i] = new LinkedList<Integer>();
            }
        }

        public void addEdge(int from, int to) {
            adjList[from].add(to);
        }
    }
}