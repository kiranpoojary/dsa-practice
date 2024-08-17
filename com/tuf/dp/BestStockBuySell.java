package com.tuf.dp;

public class BestStockBuySell {

    public void bestBuySell(int[] arr) { // TC: O(n)
        int profit = 0;
        int minPrice = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int newProfit = arr[i] - minPrice;
            profit = Math.max(profit, newProfit);
            minPrice = Math.min(minPrice, arr[i]);
        }
        System.out.println("Buy: " + minPrice + " Sell: " + (minPrice + profit));
    }

    public static void main(String[] args) {
        int[] arr = { 7, 5, 3, 9, 6, 1, 5, 8 };
        BestStockBuySell b = new BestStockBuySell();
        b.bestBuySell(arr);
    }
}
