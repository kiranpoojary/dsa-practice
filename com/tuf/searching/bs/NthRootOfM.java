package com.tuf.searching.bs;

public class NthRootOfM {

    public static int getRootOfMBrute(int n, int m) {
        int ans = -1;
        for (int i = 1; i < n; i++) { // O(n)
            if ((Math.pow(i, m)) == n) // O(log2m)
                return i;
            else if ((Math.pow(i, m)) > n)
                break;
        }
        return ans;
    }

    private static int getExpo(int mid, int num, int pow) {
        long ans = mid; // i=1
        for (int i = 2; i < pow; i++) {
            ans = ans * mid;
            if (ans > num)
                return 2;
        }
        if (ans == num)
            return 1;
        else
            return 0;
    }

    // consider overflow if integer max with mid*mid*mid...
    public static int getRootOfMBS(int num, int pow) { // TC: O(n)+O(log2m) m is pow
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = (low + high) / 2;
            int pw = (int) Math.pow(mid, pow);// u can use getExpo(mid, num, pow); to solve overflow
            if (pw == num)
                return mid;
            else if (pw > num)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("get Root of  Brute  :" + getRootOfMBrute(27, 3));
        System.out.println("get Root of  BS     :" + getRootOfMBS(27, 3));
    }
}
