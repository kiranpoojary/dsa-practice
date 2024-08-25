package com.tuf.searching.bs;

import java.util.ArrayList;
import java.util.Arrays;

public class MFlowerBouquets {
    // create k bouquet of bloomed flower with k adjecent bloomed flowers: return
    // min day u have to wait to get k bouquets of flower
    public static int[] getMinMaxOfArray(int[] arr) {
        ArrayList<Integer> ar = new ArrayList<>();
        for (Integer ele : arr) {
            ar.add(ele);
        }
        ar.sort(null);
        int[] ans = { ar.get(0), ar.get(ar.size() - 1) };
        return ans;
    }

    public static int createBouquet(int[] flowersWithBloomingDays, int day, int boquetFlowerSize) {
        int bouquetCreated = 0;
        int adjecentFlowers = 0;
        for (int i = 0; i < flowersWithBloomingDays.length; i++) {
            if (flowersWithBloomingDays[i] <= day) {
                adjecentFlowers++;
            } else {
                bouquetCreated += ((int) (adjecentFlowers / boquetFlowerSize));
                adjecentFlowers = 0;
            }
        }
        if (adjecentFlowers > 0)
            bouquetCreated += ((int) (adjecentFlowers / boquetFlowerSize));
        return bouquetCreated;

    }

    public static int getDaysForKBouquetBrute(int[] bloomingDays, int boquetFlowerSize, int requiredBouquets) {
        // O(min-max+1)+ O(n)
        int[] minmax = getMinMaxOfArray(bloomingDays);
        int ans = 0;
        if (bloomingDays.length < (boquetFlowerSize * requiredBouquets))
            return Integer.MAX_VALUE;
        for (int i = minmax[0]; i <= minmax[1]; i++) {
            int totalBouquetCreated = createBouquet(bloomingDays, i, boquetFlowerSize); // i is day
            if (totalBouquetCreated >= requiredBouquets) {
                return i;
            }
        }
        return ans;
    }

    public static int getDaysWithBS(int[] bloomingDays, int boquetFlowerSize, int requiredBouquets) {
        int[] minmax = getMinMaxOfArray(bloomingDays);
        int low = minmax[0];
        int high = minmax[1];
        int waitingDays = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalCreated = createBouquet(bloomingDays, mid, boquetFlowerSize);

            if (totalCreated >= requiredBouquets) {// more created than required, then reduce days
                waitingDays = Math.min(waitingDays, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return waitingDays; // u can return low as well
    }

    public static void main(String[] args) {
        int[] boomingDays = { 7, 7, 7, 7, 13, 11, 12, 7 };
        System.out.println("Waiting days Brute   : " + getDaysForKBouquetBrute(boomingDays, 3, 2));
        System.out.println("Waiting days BS      : " + getDaysWithBS(boomingDays, 3, 2));
    }
}
