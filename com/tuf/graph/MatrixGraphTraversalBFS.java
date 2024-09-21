package com.tuf.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MatrixGraphTraversalBFS {
    // BFS traversal function
    public static List<Integer> bfs(int[][] adjacencyMatrix, int startNode) {
        int n = adjacencyMatrix.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> traversalOrder = new ArrayList<>();

        // Start from the given node
        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            traversalOrder.add(currentNode);

            // Visit all the neighbors of the current node
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (adjacencyMatrix[currentNode][neighbor] == 1 && !visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return traversalOrder;
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

        // Perform BFS starting from node 0
        List<Integer> result = bfs(graph, 0);
        System.out.println("BFS Traversal Order: " + result);
    }
}
