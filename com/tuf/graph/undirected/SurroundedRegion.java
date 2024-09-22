package com.tuf.graph.undirected;

public class SurroundedRegion {
    // chage O to X if surrounded by X
    public static void dfs(char[][] mat, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        int[] neighbourRowSetter = { -1, 0, 1, 0 };
        int[] neighbourColSetter = { 0, 1, 0, -1 };
        for (int i = 0; i < 4; i++) { // visit all unvisited neight of curr and make it visited and push to Q
            int neighborRow = row + neighbourRowSetter[i];
            int neighborCol = col + neighbourColSetter[i];
            if (neighborRow >= 0 && neighborRow < mat.length && neighborCol >= 0
                    && neighborCol < mat[0].length && mat[neighborRow][neighborCol] == 'O'
                    && !visited[neighborRow][neighborCol]) {
                dfs(mat, visited, neighborRow, neighborCol);
            }
        }
    }

    public static char[][] createSurrounding(char[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && i < m - 1 && j > 0 && j < n - 1)
                    continue;
                if (matrix[i][j] == 'O') {
                    dfs(matrix, visited, i, j);
                }
            }
        }

        char[][] SurroundedMatrix = new char[m][n];
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                SurroundedMatrix[i][j] = 'X';
                if (visited[i][j])
                    SurroundedMatrix[i][j] = 'O';
            }
        }
        return SurroundedMatrix;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                { 'X', 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X', 'O' },
                { 'X', 'X', 'O', 'X', 'O' },
                { 'X', 'O', 'X', 'O', 'X' },
                { 'O', 'O', 'X', 'X', 'X' },
        };

        System.out.println("Original Matrix");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        char[][] resultMat = createSurrounding(matrix);
        System.out.println("Surrounded Matrix");

        for (int i = 0; i < resultMat.length; i++) {
            for (int j = 0; j < resultMat[0].length; j++) {
                System.out.print(resultMat[i][j] + " ");
            }
            System.out.println();
        }

    }
}
