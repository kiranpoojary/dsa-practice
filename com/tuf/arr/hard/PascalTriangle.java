package com.tuf.arr.hard;
//https://www.youtube.com/watch?v=bR7mQgwQ_o8&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=34

import java.util.ArrayList;
import java.util.List;

//                  1
//                1   1
//              1   2   1
//            1   3   3   1
//          1   4   6   4   1
//        1   5   10  10   5  1

public class PascalTriangle {
    public long findPascalSpecificRowColElementBrute(int row, int col) { // TC: O(r); SC O(1)
        return this.getNcRShortHand(row - 1, col - 1);
    }

    public List<Long> getPascalTriangleRowElements(int row) { // TC: O(nr)
        List<Long> eles = new ArrayList<>();
        for (int i = 1; i <= row; i++) {
            long res = this.getNcRShortHand(row - 1, i - 1);
            eles.add(res);
        }
        return eles;
    }

    public List<Long> getPascalTriangleRowElementsOptimal(int n) { // TC: O(nr)
        List<Long> eles = new ArrayList<>();
        long ans = 1;
        eles.add(ans);
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            eles.add(ans);
        }
        return eles;
    }

    public List<List<Long>> getPascalMatrix(int n) {
        List<List<Long>> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ans.add(this.getPascalTriangleRowElementsOptimal(i));
        }
        return ans;
    }

    // Utility function
    private long getNcRShortHand(int row, int col) {
        // watch video for below nCr shortcut part
        long result = 1; // SC O(1)
        for (int i = 0; i < col; i++) { // TC: O(row);
            result = result * (row - i);
            result = result / (i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        PascalTriangle p = new PascalTriangle();
        System.out.println("findPascalRowColElementBrute :" +
                p.findPascalSpecificRowColElementBrute(4, 3));
        System.out.println("getPascalTriangleRowElements :" +
                p.getPascalTriangleRowElements(5));// (row and col)
        System.out.println("getPascalTriangleRowElementsOptimal :" +
                p.getPascalTriangleRowElementsOptimal(5));// (row
        System.out.println("getPascalMatrix                     :" + p.getPascalMatrix(5));// (row
        // and
        // col)
    }
}
