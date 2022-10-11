package com.geeks.ds.greedy;

import java.util.Arrays;

/**
 * Greedy algorithm to find minimum coin required to find a given sum
 */
public class MinimumCoin {

    public static void main(String args[])
    {
        int coin[] = {5, 10, 2, 1}, n = 4, amount = 57;

        System.out.println(minCoins(coin, n, amount));

    }

    public static int minCoins(int [] coin, int n, int amount) {

        Arrays.sort(coin);
        int res = 0;
        for(int i = n - 1; i >= 0; i--) {

            if(coin[i] <= amount) {
                int selectItem = (int) Math.floor(amount/coin[i]);
                res = res + selectItem;

                amount = amount - selectItem * coin[i];
            }

            if(amount == 0) {
                break;
            }
        }

        return res;
    }
}
