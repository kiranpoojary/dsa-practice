package com.tuf.graph.directed;

import java.util.*;

public class ListEventualSafeNodeTopo {

    // NOTE::: READ READ READ
    // Eventual Safe Node: if a node is a terminal node or if every possible path
    // starting from that node leads to a terminal node
    // terminal node:- in a directed graph if a node has no out going arrow
    // node which is in cycle are not eventual safe node

    // Here we are using topo and bsf to solve problem

    public static ArrayList<Integer> getSafeNodes(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            revAdj.add(new ArrayList<>());
        }

        int[] indegree = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            for (int it : adj.get(i)) {
                revAdj.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList();
        ArrayList<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);
            for (int it : revAdj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        adjList.add(new ArrayList<>(Arrays.asList(0, 1)));
        adjList.add(new ArrayList<>(Arrays.asList(1, 2)));
        adjList.add(new ArrayList<>(Arrays.asList(2, 3)));
        adjList.add(new ArrayList<>(Arrays.asList(3, 4, 5)));
        adjList.add(new ArrayList<>(Arrays.asList(4, 6)));
        adjList.add(new ArrayList<>(Arrays.asList(5, 6)));
        adjList.add(new ArrayList<>(Arrays.asList(6, 7)));
        adjList.add(new ArrayList<>(Arrays.asList()));
        adjList.add(new ArrayList<>(Arrays.asList(8, 1, 9)));
        adjList.add(new ArrayList<>(Arrays.asList(9, 10)));
        adjList.add(new ArrayList<>(Arrays.asList(10, 8)));
        adjList.add(new ArrayList<>(Arrays.asList(11, 9)));
        System.out.println("safe node in the graph are    :" + getSafeNodes(adjList));
    }

}
