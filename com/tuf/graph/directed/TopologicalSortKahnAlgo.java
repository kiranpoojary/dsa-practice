package com.tuf.graph.directed;

import java.util.*;

public class TopologicalSortKahnAlgo {
    // Topological sort :- linear ordering of vertices such that if there is an edge
    // btw u and v, u always appears before v in that ordering
    // :- works with directed acyclic graph(DAG) only
    // indegree: No. of incoming edges

    public static ArrayList<Integer> getTopologicalOrderKahn(ArrayList<ArrayList<Integer>> adjList) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] indegree = new int[adjList.size()];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < adjList.size(); i++) {
            ArrayList<Integer> arr = adjList.get(i);
            for (Integer node : arr) {
                indegree[node]++;
            }

        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (Integer it : adjList.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
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
        System.out.println("Topological sorted graph      :" + getTopologicalOrderKahn(adjList));

    }

}
