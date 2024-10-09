package com.tuf.graph.weighted;

import java.util.ArrayList;
import java.util.Arrays;

public class CountProvincesDisjointSet {

    public static int getProvinceCount(ArrayList<ArrayList<Integer>> mat, int v) {
        DisjointSet ds = new DisjointSet(v);// creates v sized parent[], size[], rank[]
        // both loog has v bcoz adj matrix is always square matrix
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (mat.get(i).get(j) == 1)
                    ds.unionByRank(i, j);
            }
        }
        int provinceCount = 0;
        for (int i = 0; i < v; i++) {
            if (ds.parent.get(i) == i) {
                ++provinceCount;
            }
        }
        return provinceCount;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();
        adjMatrix.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0, 0, 0, 0)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(1, 0, 1, 0, 0, 0, 0, 0)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0, 0, 0, 0)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 1, 0, 0)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 1, 0, 0)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 1, 0)));
        System.out.println("Total province count    :" + getProvinceCount(adjMatrix, 7));
    }

}
