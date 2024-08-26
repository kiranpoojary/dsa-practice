package com.tuf.searching.bs;

import java.util.ArrayList;

public class ShipAllPackageInNDays {
    // you have a ship and n number of containers with different weights
    // you are given a D days to ship all container with minimum weight in ship
    // Note: ship min capacity will be min of (weight of all container)
    // Note: ship max capacity will be sum of (weight of all container)

    public static int[] getMinMaxOfArray(int[] arr) {
        ArrayList<Integer> ar = new ArrayList<>();
        for (Integer ele : arr) {
            ar.add(ele);
        }
        ar.sort(null);
        int[] ans = { ar.get(0), ar.get(ar.size() - 1) };
        return ans;
    }

    public static int getSumOfArray(int[] arr) {
        int sum = 0;
        for (Integer ele : arr) {
            sum += ele;
        }
        return sum;
    }

    public static int getDaysRequiredToShipAll(int[] containers, int maxShipCap) {
        int daysUsed = 0;
        int capacityFilled = 0;
        for (int i = 0; i < containers.length; i++) {
            capacityFilled += containers[i];
            if (capacityFilled == maxShipCap) {
                daysUsed++;
                capacityFilled = 0;
            } else if (capacityFilled > maxShipCap) {
                i--;
                daysUsed++;
                capacityFilled = 0;
            }
        }
        // Note the below case always
        if (capacityFilled > 0)
            ++daysUsed;
        return daysUsed;
    }

    public static int getMinShipCapacityBrute(int[] containers, int givenDays) {
        int[] minmax = getMinMaxOfArray(containers);
        int minCap = minmax[1]; // max will be min cap of ship
        int maxCap = getSumOfArray(containers);
        for (int i = minCap; i <= maxCap; i++) {
            int totalDaystaken = getDaysRequiredToShipAll(containers, i);
            if (totalDaystaken == givenDays)
                return i;
        }
        return -1;
    }

    public static int getMinShipCapacityBS(int[] containers, int givenDays) {
        int[] minmax = getMinMaxOfArray(containers);
        int low = minmax[1]; // min capacity
        int high = getSumOfArray(containers); // max capacity
        if ((containers.length) < givenDays)
            return -1;
        int minCap = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;// mid is capacity
            int daysTaken = getDaysRequiredToShipAll(containers, mid);
            if (daysTaken == givenDays) {
                minCap = Math.min(minCap, mid);
                high = mid - 1;

            } else if (daysTaken < givenDays) {
                high = mid - 1;
            } else if (daysTaken > givenDays) {
                low = mid + 1;
            }
        }

        return minCap;
    }

    public static void main(String[] args) {
        int[] containers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println("Ship Min Cap Brute    :" + getMinShipCapacityBrute(containers, 4));
        System.out.println("Ship Min Cap BS       :" + getMinShipCapacityBS(containers, 4));
    }
}
