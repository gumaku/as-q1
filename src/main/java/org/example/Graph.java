package org.example;

import java.util.*;

public class Graph {
    private final List<List<Integer>> adj;
    private final Map<Integer,String> alphaMap;

    public Graph() {
        this.adj = new ArrayList<>();
        this.alphaMap = new HashMap<>();
        for (char ch = 'A'; ch <= 'Z'; ++ch)
            alphaMap.put(ch - 'A', String.valueOf(ch));
    }

    public void addNode(Integer node) {
        List<Integer> list = new LinkedList<>();
        list.add(node);
        adj.add(list);
    }

    public void addEdge(int u, int v) {
        List<Integer> uList = adj.get(u);
        uList.add(v);
        List<Integer> vList = adj.get(v);
        vList.add(u);
    }

    public List<List<Integer>> findAllPaths(int src, int dest) { // BFS
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> allPaths = new ArrayList<>();
        path.add(src);
        q.offer(path);

        while (!q.isEmpty()) {
            path = q.poll();
            Integer lastNode = path.get(path.size() - 1);
            if (lastNode.equals(dest)) {
                allPaths.add(path);
            }
            List<Integer> neighbors = adj.get(lastNode);
            for (Integer neighbor : neighbors) {
                if (!path.contains(neighbor)) {
                    List<Integer> newPartialPath = new ArrayList<>(path);
                    newPartialPath.add(neighbor);
                    q.offer(newPartialPath);
                }
            }
        }
        return allPaths;
    }

    public List<Integer> findShortestPath(int src, int dest) {
        return findAllPaths(src, dest).stream().min(Comparator.comparing(List::size)).orElse(new ArrayList<>());
    }

    public void printAdj() {
        for (List<Integer> list : adj) {
            for (Integer i : list) {
                System.out.print(alphaMap.get(i) + " -> ");
            }
            System.out.println();
        }
    }

    public void printPath(List<Integer> path) {
        for (Integer node : path) {
            System.out.print(alphaMap.get(node) + " -> ");
        }
        System.out.println();
    }


}
