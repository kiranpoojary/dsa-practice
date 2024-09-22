package com.tuf.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCyclicGraphDFS {

    public static boolean hasCycleDFS(int currNode, int currNodeParent, ArrayList<ArrayList<Integer>> adjList,
            boolean[] visited) {
        visited[currNode] = true;

        for (Integer n : adjList.get(currNode)) {
            if (n == currNode)
                continue;
            if (!visited[n]) {
                if (hasCycleDFS(n, currNode, adjList, visited))
                    return true;
            } else if (currNodeParent != n) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkCycleExist(ArrayList<ArrayList<Integer>> adj, int startNode) {
        boolean[] visited = new boolean[adj.size()];
        return hasCycleDFS(startNode, -1, adj, visited);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        adjList.add(new ArrayList<>(Arrays.asList())); // 0 index
        adjList.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        adjList.add(new ArrayList<>(Arrays.asList(2, 1, 4)));
        adjList.add(new ArrayList<>(Arrays.asList(3, 1, 4)));
        adjList.add(new ArrayList<>(Arrays.asList(4, 2, 3)));

        System.out.println("Is Cyclic Graph  :" + checkCycleExist(adjList, 1));

    }
}