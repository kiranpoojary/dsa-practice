package com.tuf.graph.undirected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DfsTraversal {

    public static ArrayList<Integer> doGraphDFS(int startNode, ArrayList<ArrayList<Integer>> adj,
            ArrayList<Integer> dfs, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        while (!q.isEmpty()) {
            Integer node = q.poll();
            if (!visited[node]) {
                dfs.add(node);
                visited[node] = true;
                for (Integer ele : adj.get(node)) {
                    if (!ele.equals(node) && !visited[ele]) {
                        doGraphDFS(ele, adj, dfs, visited);
                    }
                }
            }
        }
        return dfs;
    }

    public static ArrayList<Integer> startGraphDFS(int totalNodes, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[totalNodes + 1];
        doGraphDFS(8, adj, dfs, visited);
        return dfs;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(2, 1, 5, 6)));
        adj.add(new ArrayList<>(Arrays.asList(3, 1, 4, 7)));
        adj.add(new ArrayList<>(Arrays.asList(4, 3, 8)));
        adj.add(new ArrayList<>(Arrays.asList(5, 6)));
        adj.add(new ArrayList<>(Arrays.asList(6, 2)));
        adj.add(new ArrayList<>(Arrays.asList(7, 3, 8)));
        adj.add(new ArrayList<>(Arrays.asList(8, 4, 7)));
        System.out.println("DfsTraversal    :" + DfsTraversal.startGraphDFS(8, adj));
    }
}
