package com.tuf.graph.weighted;

import java.util.HashSet;
import java.util.Set;

public class ConstructLargeIsland {
    // works with m*n matrix
    // u are allowed fill a single cell with 1 to make large island
    // return cell size of largest island after placing 1

    private static boolean isValidCell(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    public static int constructLargeIsland(int grid[][], int m, int n) {
        DisjointSet ds = new DisjointSet(n * n);
        // step 2: create disjoint set parents for each
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0)
                    continue;
                int adjRows[] = { -1, 0, 1, 0 };
                int adjCols[] = { 0, -1, 0, 1 };
                for (int ind = 0; ind < 4; ind++) {
                    int adjRow = row + adjRows[ind];
                    int adjCol = col + adjCols[ind];
                    if (isValidCell(adjRow, adjCol, m, n) && grid[adjRow][adjCol] == 1) {
                        int nodeNum = row * n + col;
                        int adjNodeNum = adjRow * n + adjCol;
                        ds.unionBySize(nodeNum, adjNodeNum);
                    }
                }
            }
        }
        // step 2: hypothetically put 1 and check size of its cinnected land cell
        int mx = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1)
                    continue;
                int adjRows[] = { -1, 0, 1, 0 };
                int adjCols[] = { 0, -1, 0, 1 };
                HashSet<Integer> components = new HashSet<>();
                for (int ind = 0; ind < 4; ind++) {
                    int adjRow = row + adjRows[ind];
                    int adjCol = col + adjCols[ind];
                    if (isValidCell(adjRow, adjCol, m, n)) {
                        if (grid[adjRow][adjCol] == 1) {
                            components.add(ds.findUPar(adjRow * n + adjCol));
                        }
                    }
                }
                int sizeTotal = 0;
                for (Integer parents : components) {
                    sizeTotal += ds.size.get(parents);
                }
                mx = Math.max(mx, sizeTotal + 1);
            }
        }
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            mx = Math.max(mx, ds.size.get(ds.findUPar(cellNo)));
        }
        return mx;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 1, 1, 0 },
                { 1, 1, 0, 1, 1, 0 },
                { 1, 1, 0, 1, 1, 0 },
                { 0, 0, 1, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 0 },
                // { 0, 0, 1, 1, 1, 0 }
        };

        System.out.println("largest island constructed  :"
                + ConstructLargeIsland.constructLargeIsland(grid, grid.length, grid[0].length));
    }
}
