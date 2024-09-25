package com.tuf.graph.directed;

import java.util.*;

public class TopologicalSort {
    // Topological sort :- linear ordering of vertices such that if there is an edge
    // btw u and v, u always appears before v in that ordering
    // :- works with directed acyclic graph only

    public static Stack<Integer> dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int startNode,
            Stack<Integer> st) {
        visited[startNode] = true;

        ArrayList<Integer> adj = adjList.get(startNode);
        for (Integer node : adj) {
            if (!visited[node]) {
                dfs(adjList, visited, node, st);
            }
        }
        st.push(startNode);
        return st;
    }

    public static ArrayList<Integer> getTopologicalOrder(ArrayList<ArrayList<Integer>> adjList) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[adjList.size()];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                st = dfs(adjList, visited, i, st);
            }
        }
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        adjList.add(new ArrayList<>(Arrays.asList()));
        adjList.add(new ArrayList<>(Arrays.asList()));
        adjList.add(new ArrayList<>(Arrays.asList(3)));
        adjList.add(new ArrayList<>(Arrays.asList(1)));
        adjList.add(new ArrayList<>(Arrays.asList(0, 1)));
        adjList.add(new ArrayList<>(Arrays.asList(0, 2)));
        System.out.println("Topological sorted graph      :" + getTopologicalOrder(adjList));

    }

}
