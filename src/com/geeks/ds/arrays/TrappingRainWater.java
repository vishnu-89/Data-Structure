package com.geeks.ds.arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 */
public class TrappingRainWater {

    public static void main(String args[]) {
        int ar[] = {5, 0, 6, 2, 3}, n = 5;

        System.out.println( "The total water can be trapped1 : "+trappingRainWater(ar, ar.length));
    }

    static int trappingRainWater(int arr[], int n) {
        int res = 0;

        int lMax[] = new int[n];
        int rMax[] = new int[n];

        lMax[0] = arr[0];
        for(int i = 1; i < n; i++) {
            lMax[i] = Math.max(arr[i], lMax[i - 1]);
        }

        rMax[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(arr[i], rMax[i + 1]);
        }

        for(int i = 1; i < n - 1; i++) {
            res = res + (Math.min(lMax[i], rMax[i]) - arr[i]);
        }

        return res;
    }
}
