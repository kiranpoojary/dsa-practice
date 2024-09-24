package com.tuf.graph.directed;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckCycle {

    public static boolean isCyclickDirectedGraphDFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited,
            boolean[] pathVisited, int startNode) {
        visited[startNode] = true;
        pathVisited[startNode] = true;
        ArrayList<Integer> adjChilds = adj.get(startNode);
        for (Integer node : adjChilds) {
            if (node == startNode)
                continue;
            if (!visited[node]) {
                if (isCyclickDirectedGraphDFS(adj, visited, pathVisited, node) == true)
                    return true;
            } else if (pathVisited[node])
                return true;
        }

        pathVisited[startNode] = false;
        return false;
    }

    public static boolean hasCycle(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        boolean[] pathVisited = new boolean[adj.size()];
        for (int index = 1; index < adj.size(); index++) {
            if (!visited[index]) {
                if (isCyclickDirectedGraphDFS(adj, visited, pathVisited, index) == true) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        adjList.add(new ArrayList<>(Arrays.asList())); // 0 index
        adjList.add(new ArrayList<>(Arrays.asList(1, 2)));
        adjList.add(new ArrayList<>(Arrays.asList(2, 3)));
        adjList.add(new ArrayList<>(Arrays.asList(3, 4, 7)));
        adjList.add(new ArrayList<>(Arrays.asList(4, 5)));
        adjList.add(new ArrayList<>(Arrays.asList(5, 6)));
        adjList.add(new ArrayList<>(Arrays.asList()));
        adjList.add(new ArrayList<>(Arrays.asList(7, 5)));
        adjList.add(new ArrayList<>(Arrays.asList(8, 9)));
        adjList.add(new ArrayList<>(Arrays.asList(9, 10)));
        adjList.add(new ArrayList<>(Arrays.asList(10, 8)));
        System.out.println("Is cyclic directed graph-1     :" + hasCycle(adjList));
    }

}
