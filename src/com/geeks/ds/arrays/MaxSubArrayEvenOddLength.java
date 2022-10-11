package com.geeks.ds.arrays;

/**
 * For a given array fine the maximum length of an subarray whose elements consists of only odd and even number
 */
public class MaxSubArrayEvenOddLength {

    public static void main(String args[]) {
        int ar[] = {5, 10, 20, 6, 3, 8};
        int len = ar.length;

        System.out.println(maxEvenOdd(ar, len));

    }

    private static int maxEvenOdd(int ar[], int len) {
        int res = 1;
        int curr = 1;

        for(int i = 1; i < len; i++) {
            if((ar[i] % 2 == 0 && ar[i - 1] % 2 != 0) || (ar[i] % 2 != 0 && ar[i - 1] % 2 == 0)) {
                curr++;
                res = Math.max(res, curr);
            }
            else {
                curr = 1;
            }
        }

        return res;
    }
}
