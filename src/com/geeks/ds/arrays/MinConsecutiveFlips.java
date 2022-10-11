package com.geeks.ds.arrays;

/**
 * Given a binary array, we need to convert this array into an array that either contains all 1s or all 0s.
 * We need to do it using the minimum number of group flips.
 */
public class MinConsecutiveFlips {

    public static void main(String args[]) {
        int ar[] = {0, 0, 1, 1, 0, 0, 1, 1, 0}, n = 9;

        printGroups(ar, ar.length);

    }

    static void printGroups(int arr[], int n) {
        for(int i = 1; i < n; i++) {
            if(arr[i] != arr[i - 1]) {
                if(arr[i] != arr[0])
                    System.out.print("From " + i + " to ");
                else
                    System.out.println(i - 1);
            }
        }

        if(arr[n - 1] != arr[0]) {
            System.out.println(n-1);
        }

    }
}
