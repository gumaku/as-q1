package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph = getGraph(); // Given Graph
        System.out.println("Adjacency lists:");
        graph.printAdj();
        System.out.println();

        System.out.println("Find all possible paths:");
        List<List<Integer>> possiblePaths = graph.findAllPaths(0, 7);
        for (List<Integer> path : possiblePaths) {
            graph.printPath(path);
        }
        System.out.println();

        System.out.println("Find shortest paths:");
        List<Integer> shortestPath = graph.findShortestPath(0, 7);
        graph.printPath(shortestPath);
    }

    private static Graph getGraph() {
        Graph graph = new Graph();

        graph.addNode(0); // 0 -> A
        graph.addNode(1); // 1 -> B
        graph.addNode(2); // 2 -> C
        graph.addNode(3); // 3 -> D
        graph.addNode(4); // 4 -> E
        graph.addNode(5); // 5 -> F
        graph.addNode(6); // 6 -> G
        graph.addNode(7); // 7 -> H

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 7);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        return graph;
    }
}