package com.tuf.searching.bs;
//https://www.youtube.com/watch?v=qyfekrNni90&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=56

public class KokoEatingBanana {
    // finish all the banana in giben H hours by eating minimm of k banana/hr

    public static int getTotalHoursToEatAllBananaMidHourly(int[] bananaPiles, int perHourCapacity) {
        int totalHoursRequired = 0;
        for (int i = 0; i < bananaPiles.length; i++) { // m
            totalHoursRequired += Math.ceilDiv(bananaPiles[i], perHourCapacity);
        }
        return totalHoursRequired;
    }

    public static int getEatBananaPerHourBrute(int[] piles, int givenHrs) { // TC O(n*m)
        int usedHrs = Integer.MAX_VALUE;

        for (int i = 1; i <= piles[piles.length - 1]; i++) { // n
            usedHrs = getTotalHoursToEatAllBananaMidHourly(piles, i); // m
            if (usedHrs <= givenHrs)
                return i;
        }
        return -1;
    }

    public static int getEatBananaPerHourBS(int[] piles, int givenHrs) { // TC O(n)+O(log2(max ele))
        int n = piles.length;
        int low = 1;
        int high = piles[n - 1];
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalHoursForNBanana = getTotalHoursToEatAllBananaMidHourly(piles, mid);
            if (totalHoursForNBanana <= givenHrs) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return ans; // u can return low
    }

    public static void main(String[] args) {
        int[] bananaPiles = { 3, 4, 5, 7, 8 };
        System.out.println("Banana Brute    : " + getEatBananaPerHourBrute(bananaPiles, 8));
        System.out.println("Banana BS       : " + getEatBananaPerHourBS(bananaPiles, 8));

    }
}
