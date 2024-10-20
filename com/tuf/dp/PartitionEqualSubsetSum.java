package com.tuf.dp;

public class PartitionEqualSubsetSum {

    // public static boolean hasSumSubsets(int[] arr)
    public static void main(String[] args) {
        int[] arr = { 2, 3, 3, 3, 4, 5 };
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        if (total % 2 == 0) {
            SubsetSumIsK sum = new SubsetSumIsK();
            System.out
                    .println("has 2 equal sum array subsets(recu)   :"
                            + sum.hasSubsetTargetSumRecursive(arr, arr.length - 1, 4));
            System.out
                    .println("has 2 equal sum array subsets(memo)   :"
                            + sum.hasSubsetTargetSumRecursive(arr, arr.length - 1, 4));
            System.out.println("has 2 equal sum array subsets(tabu)   :" + sum.hasSubsetTargetSumTabualation(arr, 4));
            System.out.println("has 2 equal sum array subsets(spac)   :" + sum.hasSubsetTargetSumSpaceOpti(arr, 4));
        } else
            System.out.println("not possile to split array int 2 subset as sum is odd");

    }
}
