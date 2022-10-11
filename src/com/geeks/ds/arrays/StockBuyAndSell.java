package com.geeks.ds.arrays;

/**
 * The cost of a stock on each day is given in an array,
 * find the max profit that you can make by buying and selling in those days
 */
public class StockBuyAndSell {

    public static void main(String args[]) {
        int ar[] = {1, 5, 3, 8, 12}, n = 5;

        System.out.println(maxProfit(ar, 0, n-1));

    }

    static int maxProfit(int price[], int start, int end) {
        if(end <= start)
            return 0;

        int profit = 0;

        for(int i = start; i < end; i++) {
            for(int j = i + 1; j <= end; j++) {
                if(price[j] > price[i]) {
                    int curr_profit = price[j] - price[i]
                            + maxProfit(price, start, i - 1)
                            + maxProfit(price, j + 1, end);

                    profit = Math.max(profit, curr_profit);
                }
            }
        }

        return profit;
    }
    // Solution 2
    private static int maxProfit1(int price[], int n) {
        int profit = 0;

        for(int i = 1; i < n; i++) {
            if(price[i] > price[i - 1]) {
                profit += price[i] - price[i -1];
            }
        }
        return profit;
    }
}
