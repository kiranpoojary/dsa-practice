package com.tuf.graph.weighted;

import java.util.HashMap;
import java.util.Map;

public class RemoveMaxStones {
    // https://www.youtube.com/watch?v=OwMNX8SPavM&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=178
    // rows(0 to n) treated as node
    // stones(marked cell) treated as connecting node

    public static int countMaxStoneToRemove(int[][] stones, int stoneCount) {
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < stoneCount; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        for (int i = 0; i < stoneCount; i++) {
            int rowNode = stones[i][0];
            int colNode = stones[i][1] + maxRow + 1;
            ds.unionBySize(rowNode, colNode);
            stoneNodes.put(rowNode, 1);
            stoneNodes.put(colNode, 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> it : stoneNodes.entrySet()) {
            if (ds.findUPar(it.getKey()) == it.getKey()) {
                ++count;
            }
        }
        return stoneCount - count;
    }

    public static void main(String[] args) {
        int[][] stonePositions = {
                { 0, 1 },
                { 0, 2 },
                { 1, 3 },
                { 3, 0 },
                { 3, 2 },
                { 4, 3 }
        };

        System.out.println(
                "max stone reved  :" + RemoveMaxStones.countMaxStoneToRemove(stonePositions, stonePositions.length));
    }
}
