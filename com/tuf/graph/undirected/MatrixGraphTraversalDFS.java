package com.tuf.graph.undirected;

import java.util.ArrayList;
import java.util.List;

public class MatrixGraphTraversalDFS {

    // DFS traversal function
    public static List<Integer> dfs(int[][] adjacencyMatrix, int startNode) {
        int n = adjacencyMatrix.length;
        boolean[] visited = new boolean[n];
        List<Integer> traversalOrder = new ArrayList<>();

        // Start the DFS
        dfsHelper(adjacencyMatrix, startNode, visited, traversalOrder);

        return traversalOrder;
    }

    // Helper function for DFS using recursion
    private static void dfsHelper(int[][] adjacencyMatrix, int currentNode, boolean[] visited,
            List<Integer> traversalOrder) {
        visited[currentNode] = true;
        traversalOrder.add(currentNode);

        // Visit all the neighbors of the current node
        for (int neighbor = 0; neighbor < adjacencyMatrix.length; neighbor++) {
            if (adjacencyMatrix[currentNode][neighbor] == 1 && !visited[neighbor]) {
                dfsHelper(adjacencyMatrix, neighbor, visited, traversalOrder);
            }
        }
    }

    public static void main(String[] args) {
        // Example adjacency matrix representing the graph
        int[][] graph = {
                { 0, 1, 0, 0, 1, 0, 0 },
                { 1, 0, 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 1, 0 },
        };

        // Perform DFS starting from node 0
        List<Integer> result = dfs(graph, 0);
        System.out.println("DFS Traversal Order: " + result);
    }

}
