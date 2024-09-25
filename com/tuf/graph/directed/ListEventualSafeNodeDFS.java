package com.tuf.graph.directed;

import java.util.*;

public class ListEventualSafeNodeDFS {
    // NOTE::: READ READ READ
    // Eventual Safe Node: if a node is a terminal node or if every possible path
    // starting from that node leads to a terminal node
    // terminal node:- in a directed graph if a node has no out going arrow
    // node which is in cycle are not eventual safe node

    public static boolean isCyclickDirectedGraphDFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited,
            boolean[] pathVisited, int startNode, boolean[] safeNodes) {
        visited[startNode] = true;
        pathVisited[startNode] = true;
        safeNodes[startNode] = false;
        ArrayList<Integer> adjChilds = adj.get(startNode);
        for (Integer node : adjChilds) {
            if (node == startNode)
                continue;
            if (!visited[node]) {
                if (isCyclickDirectedGraphDFS(adj, visited, pathVisited, node, safeNodes) == true)
                    return true;
            } else if (pathVisited[node])
                return true;
        }

        safeNodes[startNode] = true;
        pathVisited[startNode] = false; // reset path visit if cycle not found
        return false;
    }

    public static ArrayList<Integer> getSafeNodes(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        boolean[] pathVisited = new boolean[adj.size()];
        boolean[] safeNodes = new boolean[adj.size()];
        for (int index = 1; index < adj.size(); index++) {
            if (!visited[index]) {
                if (isCyclickDirectedGraphDFS(adj, visited, pathVisited, index, safeNodes) == true) {
                    // return true;
                }
            }
        }
        ArrayList<Integer> safe = new ArrayList<>();
        for (int i = 0; i < safeNodes.length; i++) {
            if (safeNodes[i])
                safe.add(i);
        }

        return safe;

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
        System.out.println("Is cyclic directed graph-1     :" + getSafeNodes(adjList));
    }

}
