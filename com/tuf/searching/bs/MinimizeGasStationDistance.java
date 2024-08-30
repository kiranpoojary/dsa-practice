package com.tuf.searching.bs;

import java.util.PriorityQueue;

public class MinimizeGasStationDistance {
    // u are give gas station with distance in array
    // reduce gas station distance by putting extra k stations
    // return maximum distance after reducing distance

    public static double getMaxStationDistanceBrute(double[] stations, int k) {// TC: O(k*n)+O(n)
        int[] placementCount = new int[stations.length - 1];
        for (int i = 0; i < k; i++) {
            double maxDist = -1;
            int maxDistIndex = -1;

            for (int j = 0; j < (stations.length - 1); j++) {
                double currDistance = stations[j + 1] - stations[j];
                double currSectionDistance = (double) (currDistance / (placementCount[j] + 1));
                if (maxDist < currSectionDistance) {
                    maxDist = currSectionDistance;
                    maxDistIndex = j;
                }
            }
            placementCount[maxDistIndex]++;
        }

        double finalMax = -1;
        for (int i = 0; i < (stations.length - 1); i++) {
            double actualDistance = stations[i + 1] - stations[i];
            double totalSections = placementCount[i] + 1;
            double afterDistance = (double) actualDistance / totalSections;
            finalMax = Math.max(finalMax, afterDistance);
        }
        return finalMax;
    }

    public static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static double getMaxStationDistanceBetter(double[] stations, int k) { // TC: O(n)+O(k) SC:O(n-1)
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));

        int[] placementCount = new int[stations.length - 1];
        for (int i = 0; i < (stations.length - 1); i++) {
            maxHeap.add(new Pair(stations[i + 1] - stations[i], i));
        }
        // Pick and place k gas stations:
        for (int gasStations = 1; gasStations <= k; gasStations++) {
            Pair tp = maxHeap.poll();
            int secInd = tp.second;

            placementCount[secInd]++;
            double inidiff = stations[secInd + 1] - stations[secInd];
            double newSecLen = inidiff / (double) (placementCount[secInd] + 1);
            maxHeap.add(new Pair(newSecLen, secInd));
        }
        return maxHeap.peek().first;
    }

    // ---------------------------
    public static int numberOfGasStationsRequired(double dist, double[] arr) {
        int n = arr.length; // size of the array
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int numberInBetween = (int) ((arr[i] - arr[i - 1]) / dist);
            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }

    public static double getMaxStationDistanceOptimalBS(double[] stations, int k) {
        int n = stations.length; // size of the array
        double low = 0;
        double high = 0;

        // Find the maximum distance:
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, (double) (stations[i + 1] - stations[i]));
        }

        // Apply Binary search:
        double diff = 1e-6;
        while (high - low > diff) {
            double mid = (low + high) / (2.0);
            int cnt = numberOfGasStationsRequired(mid, stations);
            if (cnt > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        double[] currentGasStation = { 1, 13, 17, 23 };
        System.out.println("Distance Brute        : " + getMaxStationDistanceBrute(currentGasStation, 4));
        System.out.println("Distance Better       : " + getMaxStationDistanceBetter(currentGasStation, 4));
        System.out.println("Distance Opti BS      : " + getMaxStationDistanceOptimalBS(currentGasStation, 4));
    }
}