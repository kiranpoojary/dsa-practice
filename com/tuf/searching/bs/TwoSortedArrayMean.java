package com.tuf.searching.bs;

public class TwoSortedArrayMean {

    public static double getMeanBrute(int[] a, int[] b) { // TC: O(n1+n2) ; SC: O(n1+n2)
        int n1 = a.length;
        int n2 = b.length;
        int n = n1 + n2;
        int[] c = new int[n];
        int left = 0;
        int right = 0;
        for (int i = 0; i < Math.max(n1, n2); i++) {
            if (a[left] < b[right]) {
                c[i] = a[left];
                ++left;
            } else {
                c[i] = b[right];
                ++right;
            }
        }
        int i = Math.max(n1, n2);
        while (left < n1) {
            c[i] = a[left];
            ++left;
            ++i;
        }

        while (right < n2) {
            c[i] = b[right];
            ++right;
            ++i;
        }
        if (n % 2 == 0) {
            int idx2 = ((n + 1) / 2);
            int idx1 = idx2 - 1;
            double sum = (double) (c[idx1] + c[idx2]);
            return (double) sum / 2;
        } else {
            return (double) c[(n1 + n2) / 2];
        }
    }

    public static double getMeanBetter(int[] a, int[] b) { // TC: O(n1+n2) ; SC: O(1)
        int n1 = a.length;
        int n2 = b.length;
        int n = (n1 + n2);
        int secondIndex = n / 2;
        int firstIndexValue = 0;
        int firstIndex = secondIndex - 1;
        int secondIndexValue = 0;
        int left = 0;
        int right = 0;
        int currSortIndex = 0;
        while (left < n1 && right < n2) {
            if (a[left] < b[right]) {
                if (currSortIndex == firstIndex)
                    firstIndexValue = a[left];
                else if (currSortIndex == secondIndex)
                    secondIndexValue = a[left];

                ++left;
            } else {
                if (currSortIndex == firstIndex)
                    firstIndexValue = b[right];
                else if (currSortIndex == secondIndex) {
                    secondIndexValue = b[right];
                }
                ++right;
            }
            ++currSortIndex;
        }

        while (left < n1) {
            if (currSortIndex == firstIndex)
                firstIndexValue = a[left];
            else if (currSortIndex == secondIndex)
                secondIndexValue = a[left];
            ++currSortIndex;
            ++left;
        }

        while (right < n2) {
            if (currSortIndex == firstIndex)
                firstIndexValue = b[right];
            else if (currSortIndex == secondIndex) {
                secondIndexValue = b[right];
            }
            ++currSortIndex;
            ++right;
        }
        if (n % 2 == 0) {
            return ((firstIndexValue + secondIndexValue) / 2.0);

        } else {
            return firstIndexValue;
        }
    }

    public static double getMeanOptimalBS(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        if (n1 > n2)
            return getMeanOptimalBS(b, a);
        int n = n1 + n2;
        int left = (n + 1) / 2;
        int low = 0;
        int high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if (mid1 < n1)
                r1 = a[mid1];
            if (mid2 < n2)
                r2 = b[mid2];
            if (mid1 - 1 >= 0)
                l1 = a[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = b[mid2 - 1];

            if (l1 < r2 && l2 < r1) {
                if (n % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return (double) Math.max(l1, l2);
                }
            } else if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }
        return 0;
    }

    public static double getMeanOptimalBSPractice(int[] a, int[] b) {// TC: O(min(logn, logm)) ; O(1)
        int n1 = a.length;
        int n2 = b.length;
        int n = n1 + n2;
        if (n1 > n2)
            return getMeanOptimalBSPractice(b, a);
        int low = 0;
        int high = n1;
        int leftStart = (n1 + n2 + 1) / 2;// startPoint of left (left length==rightLength)

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = leftStart - mid1;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;

            if (mid2 < n1)
                r1 = a[mid1];
            if (mid2 < n2)
                r2 = b[mid2];
            if (mid1 - 1 >= 0)
                l1 = a[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = b[mid2 - 1];

            if (l1 < r2 && l2 < r1) {
                if ((n % 2) == 0) {
                    return ((Math.max(l1, l2) + Math.min(r1, r2)) / 2.0); // div by 2.0
                } else {
                    return Math.min(r1, r2);
                }
            } else if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 4, 5, 7, 8, 10 };
        int[] arr2 = { 1, 3, 6, 14 };
        System.out.println("Brute Mean              :" + getMeanBrute(arr1, arr2));
        System.out.println("Better Mean             :" + getMeanBetter(arr1, arr2));
        System.out.println("Optimal Mean            :" + getMeanOptimalBS(arr1, arr2));
        System.out.println("Optimal Practice Mean   :" + getMeanOptimalBSPractice(arr1, arr2));

    }
}
