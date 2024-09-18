package com.tuf.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BfsTraversal {

    public static ArrayList<Integer> startGraphBFS(int totalNodes, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visitedNodes = new boolean[totalNodes + 1];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> traversal = new ArrayList<>();
        q.add(1);
        while (!q.isEmpty()) {
            Integer node = q.poll();
            if (!visitedNodes[node]) {
                traversal.add(node);
                visitedNodes[node] = true;
                for (Integer adjNode : adj.get(node)) {
                    if (!visitedNodes[adjNode])
                        q.add(adjNode);
                }
            }
        }
        return traversal;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList()));
        adj.add(new ArrayList<>(Arrays.asList(1, 2, 3, 8)));
        adj.add(new ArrayList<>(Arrays.asList(2, 1, 4, 5, 6)));
        adj.add(new ArrayList<>(Arrays.asList(3, 1, 6, 7, 8)));
        adj.add(new ArrayList<>(Arrays.asList(4, 2)));
        adj.add(new ArrayList<>(Arrays.asList(5, 2, 9)));
        adj.add(new ArrayList<>(Arrays.asList(6, 2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(7, 3, 8, 10)));
        adj.add(new ArrayList<>(Arrays.asList(8, 1, 7)));
        adj.add(new ArrayList<>(Arrays.asList(9, 5)));
        adj.add(new ArrayList<>(Arrays.asList(10, 7)));
        System.out.println(BfsTraversal.startGraphBFS(10, adj));
    }
}
