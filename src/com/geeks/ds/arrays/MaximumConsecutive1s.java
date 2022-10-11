package com.geeks.ds.arrays;

/**
 * Find count of maximum consecutive 1s in a binary array.
 */
public class MaximumConsecutive1s {

    public static void main(String args[]) {
        int ar[] = {0, 1, 1, 0, 1, 1, 1};

        System.out.println("The maximum consecutive ones :"+maxConsecutiveOnes(ar, ar.length));
    }

    private static int maxConsecutiveOnes(int ar[], int n) {
        int res = 0;
        int curr = 0;

        for(int i = 0; i < n; i++) {
            if(ar[i] == 0) {
                curr = 0;
            }
            else {
                curr++;
                res = Math.max(res, curr);
            }
        }

        return res;
    }

}
