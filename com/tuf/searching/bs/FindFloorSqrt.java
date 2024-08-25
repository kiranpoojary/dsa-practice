package com.tuf.searching.bs;

public class FindFloorSqrt {

    public static int getSqrtBrute(int n) { // O(n)
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            if ((i * i) <= n)
                ans = i;
            else
                break;
        }
        return ans;
    }

    public static int getBSSqrt(int n) {
        int low = 1;
        int high = n;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid * mid) <= n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("SQRT Brute   : " + getSqrtBrute(28));
        System.out.println("SQRT BS      : " + getBSSqrt(28));
    }
}
