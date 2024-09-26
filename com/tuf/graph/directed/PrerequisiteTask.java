package com.tuf.graph.directed;

import java.util.*;

public class PrerequisiteTask {
    // schedule means {1,3}-> task 3 can be completed only after 1 is completed
    // is a graph has cycle then it's not possible to complete all task

    // using dfs( when No ordering required)
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

        pathVisited[startNode] = false; // reset path visit if cycle not found
        return false;
    }

    public static boolean hasCycle(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        boolean[] pathVisited = new boolean[adj.size()];
        for (int index = 0; index < adj.size(); index++) {
            if (!visited[index]) {
                if (isCyclickDirectedGraphDFS(adj, visited, pathVisited, index) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canFinishAllScheduledTaskDFS(ArrayList<ArrayList<Integer>> adj) {
        return !hasCycle(adj);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> taskList1 = new ArrayList<>();

        taskList1.add(new ArrayList<>(Arrays.asList()));
        taskList1.add(new ArrayList<>(Arrays.asList(1, 0)));
        taskList1.add(new ArrayList<>(Arrays.asList(2, 1)));
        taskList1.add(new ArrayList<>(Arrays.asList(3, 2)));
        // -------
        ArrayList<ArrayList<Integer>> taskList2 = new ArrayList<>();
        taskList2.add(new ArrayList<>(Arrays.asList()));
        taskList2.add(new ArrayList<>(Arrays.asList(1, 2)));
        taskList2.add(new ArrayList<>(Arrays.asList(4, 3)));
        taskList2.add(new ArrayList<>(Arrays.asList(2, 4)));
        taskList2.add(new ArrayList<>(Arrays.asList(4, 1)));

        System.out.println("can finish all task-dfs-1      :" + canFinishAllScheduledTaskDFS(taskList1));
        System.out.println("can finish all task-dfs-2      :" + canFinishAllScheduledTaskDFS(taskList2));

    }

}
