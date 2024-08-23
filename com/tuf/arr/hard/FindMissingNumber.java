package com.tuf.arr.hard;

/**
 * FindMissingNumber and repeated number between 9 to n and
 */
public class FindMissingNumber {

    private int[] getMissingBrute(int[] arr) { // TC: O(n^2) SC: O(1)
        int[] ans = new int[2]; // 0:miss ; 1:repeated
        for (int i = 1; i <= arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (i == arr[j]) {
                    ++count;
                    if (count > 1)
                        break;
                }
            }
            if (count == 2)
                ans[1] = i;
            else if (count == 0)
                ans[0] = i;

        }
        return ans;
    }

    private int[] getMissingBetter(int[] arr) { // TC: O(2n) ; SC: O(n)
        int[] ans = new int[2]; // 0 miss: 1:repeated
        int[] hashArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            hashArr[arr[i]] = ++hashArr[arr[i]];
        }

        for (int i = 1; i < hashArr.length; i++) {
            if (hashArr[i] >= 2)
                ans[1] = i;
            else if (hashArr[i] == 0)
                ans[0] = i;

        }

        return ans;
    }

    private int[] getMissingOptimal(int[] a) { // TC: O(n) ; SC: O(1)
        long n = a.length; // size of the array
        // Find Sn and S2n:
        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        // Calculate S and S2:
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += a[i];
            S2 += (long) a[i] * (long) a[i];
        }

        // S-Sn = X-Y:
        long val1 = S - SN;

        // S2-S2n = X^2-Y^2:
        long val2 = S2 - S2N;

        // Find X+Y = (X^2-Y^2)/(X-Y):
        val2 = val2 / val1;

        // Find X and Y: X = ((X+Y)+(X-Y))/2 and Y = X-(X-Y),
        // Here, X-Y = val1 and X+Y = val2:
        long x = (val1 + val2) / 2;
        long y = x - val1;

        int[] ans = { (int) x, (int) y };
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 3, 2, 1, 2 };
        FindMissingNumber f = new FindMissingNumber();
        int[] ans = new int[2];
        ans = f.getMissingBrute(arr);
        System.out.println("Brute Missing       :" + ans[0]);
        System.out.println("Brute Repeated      :" + ans[1]);
        System.out.println("-------------------");
        ans = f.getMissingBetter(arr);
        System.out.println("Better Missing      :" + ans[0]);
        System.out.println("Better Repeated     :" + ans[1]);
        System.out.println("-------------------");
        ans = f.getMissingOptimal(arr);
        System.out.println("Optimal Missing     :" + ans[0]);
        System.out.println("Optimal Repeated    :" + ans[1]);

    }
}