package com.tuf.searching.bs;

import java.util.ArrayList;

public class AggressiveCows {

    public static int[] getMinMaxOfArray(int[] arr) {
        ArrayList<Integer> ar = new ArrayList<>();
        for (Integer ele : arr) {
            ar.add(ele);
        }
        ar.sort(null);
        int[] ans = { ar.get(0), ar.get(ar.size() - 1) };
        return ans;
    }

    public static boolean canPlaceCows(int[] stallDistances, int noOfCows, int minDistanceToMaintain) {
        int lastPlacedDistance = stallDistances[0];
        int totalCowsPlaced = 1;
        for (int i = 1; i < stallDistances.length; i++) {
            if ((stallDistances[i] - lastPlacedDistance) >= minDistanceToMaintain) {
                totalCowsPlaced++;
                lastPlacedDistance = stallDistances[i];
            }
            if (totalCowsPlaced == noOfCows)
                return true;
        }
        return false;
    }

    public static int getCowDistanceBrute(int[] stallDistances, int noOfCows) {
        int maxDistance = stallDistances[stallDistances.length - 1] - stallDistances[0];
        int ans = 0;
        if (noOfCows > stallDistances.length)
            return 0;
        for (int i = 1; i <= maxDistance; i++) {
            boolean canPlace = canPlaceCows(stallDistances, noOfCows, i);
            if (canPlace) {
                ans = i;
            }
        }
        return ans;
    }

    public static int getCowDistanceBS(int[] stallDistances, int noOfCows) { // TC: O(nlogn)+(O(log2(max-min))*O(n)) SC:
                                                                             // O(1)
        // sort if not sorted //O(nlogn)
        int[] minmax = getMinMaxOfArray(stallDistances);
        int low = minmax[0];
        int high = minmax[1];
        int maxDist = 0;
        if (noOfCows > stallDistances.length)
            return 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean canPlace = canPlaceCows(stallDistances, noOfCows, mid);
            if (canPlace) {
                maxDist = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return maxDist;

    }

    public static void main(String[] args) {
        int[] stallDistances = { 0, 3, 4, 7, 9, 10 };
        System.out.println("Aggressive Cows Brute    : " + getCowDistanceBrute(stallDistances, 4));
        System.out.println("Aggressive Cows BS       : " + getCowDistanceBS(stallDistances, 4));
    }
}
