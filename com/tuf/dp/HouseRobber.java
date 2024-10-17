package com.tuf.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class HouseRobber {
    // there are n homes in circle structure
    // if adj house broken police will be alerted
    // broke home and get max money without alert police
    // Note: homes in cirle and adj not possible

    public static int getMaxMoneyHouseRobberRecursive(int idx, ArrayList<Integer> arr) {

        if (idx == 0)
            return arr.get(idx);
        if (idx < 0)
            return 0;
        int pick = arr.get(idx) + getMaxMoneyHouseRobberRecursive(idx - 2, arr);
        int notPick = 0 + getMaxMoneyHouseRobberRecursive(idx - 1, arr);

        return Math.max(pick, notPick);

    }

    public static int getMaxRobberyRecursive(int[] houseWealth) {
        int totalHouse = houseWealth.length;
        ArrayList<Integer> excludingFirstHouse = new ArrayList<>();
        ArrayList<Integer> excludingLasttHouse = new ArrayList<>();
        for (int i = 0; i < totalHouse; i++) {
            if (i > 0)
                excludingFirstHouse.add(houseWealth[i]);
            if (i < totalHouse - 1)
                excludingLasttHouse.add(houseWealth[i]);
        }

        // -2 becoz its 0 based index and excludes first/last
        int noFirstHouse = getMaxMoneyHouseRobberRecursive(totalHouse - 2, excludingFirstHouse);
        int noLastHouse = getMaxMoneyHouseRobberRecursive(totalHouse - 2, excludingFirstHouse);

        return Math.max(noFirstHouse, noLastHouse);
    }

    public static int getMaxMoneyHouseRobberTabulationSpaceOptimized(int idx, ArrayList<Integer> arr) {
        int prev = arr.get(0);
        int prev2 = 0;
        for (int i = 1; i < arr.size(); i++) {
            int pick = arr.get(i);
            if (i > 1)
                pick += prev2;
            int notPick = 0 + prev;
            int curi = Math.max(pick, notPick);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }

    public static int getMaxRobberyTabulation(int[] houseWealth) {
        int totalHouse = houseWealth.length;
        ArrayList<Integer> excludingFirstHouse = new ArrayList<>();
        ArrayList<Integer> excludingLasttHouse = new ArrayList<>();
        for (int i = 0; i < totalHouse; i++) {
            if (i > 0)
                excludingFirstHouse.add(houseWealth[i]);
            if (i < totalHouse - 1)
                excludingLasttHouse.add(houseWealth[i]);
        }
        // -2 becoz its 0 based index and excludes first/last
        int noFirstHouse = getMaxMoneyHouseRobberTabulationSpaceOptimized(totalHouse - 2, excludingFirstHouse);
        int noLastHouse = getMaxMoneyHouseRobberTabulationSpaceOptimized(totalHouse - 2, excludingFirstHouse);
        return Math.max(noFirstHouse, noLastHouse);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 9 };
        System.out.println(
                "Max robbed recursive           :" + getMaxRobberyRecursive(arr));
        System.out.println(
                "Max robbed space optimized     :" + getMaxRobberyTabulation(arr));
    }
}
