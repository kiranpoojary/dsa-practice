package com.tuf.graph.undirected;

public class FloodFill {

    public static void dfsFloodFIll(int[][] image, int[][] imageCopy, int currRow, int currCol, int fillColor) {
        int[] neighbourRowSetter = { -1, 0, 1, 0 };
        int[] neighbourColSetter = { 0, 1, 0, -1 };
        int initialColor = imageCopy[currRow][currCol];
        imageCopy[currRow][currCol] = fillColor;
        for (int i = 0; i < 4; i++) {
            int neighborRow = currRow + neighbourRowSetter[i];
            int neighborCol = currCol + neighbourColSetter[i];
            if (neighborRow >= 0 && neighborRow < image.length && neighborCol >= 0 && neighborCol < image[0].length
                    && imageCopy[neighborRow][neighborCol] == initialColor) {
                dfsFloodFIll(image, imageCopy, neighborRow, neighborCol, fillColor);
            }

        }
    }

    public static void startFloodFill(int[][] image, int startRow, int startCol, int fillColor) {
        int[][] imageCopy = image;
        dfsFloodFIll(image, imageCopy, startRow, startCol, fillColor);

    }

    public static void main(String[] args) {
        // Example adjacency matrix representing the graph
        int[][] image = {
                { 1, 1, 1, 0 },
                { 2, 2, 0, 0 },
                { 2, 2, 2, 0 },
                { 1, 0, 2, 0 },
                { 1, 1, 2, 0 },
        };
        System.out.println("Original Image");
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }

        startFloodFill(image, 2, 0, 4);

        System.out.print("\nfill from pixel 2,0 with color 4");
        System.out.println("\nFlood Filled Image");

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

}
