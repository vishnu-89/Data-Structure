package com.geeks.ds.sorting;

import java.util.Arrays;

/**
 * Given an unsorted array, find the minimum difference between any pair in given array.
 */
public class MinimumDifferenceInArray {

    public static void main (String[] args) {

        int arr[] = {1, 5, 3, 19, 18, 25};

        System.out.println(getMinDiff(arr, arr.length));
    }

    static int getMinDiff(int arr[], int n){
        Arrays.sort(arr);

        int res = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            res = Math.min(res, arr[i] - arr[i-1]);
        }
        return res;
    }

}
