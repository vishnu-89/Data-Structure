package com.geeks.ds.arrays;

/**
 * Given an array  of positive integers of size N. Reverse every sub-array group of size K.
 */
public class ReverseArrayInGroups {

    public static void main(String [] args) {

        int ar[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int len = ar.length;
        int K = 3;

        reverseInGroup(ar,len,K);

        for (int i = 0; i < len; i++) {
            System.out.print(ar[i] + " ");
        }

    }

    private static void reverseInGroup(int ar[] , int len , int k) {

        for (int i = 0; i < len; i = i+k) {
            int left = i;

            int right = Math.min(i + k - 1, len - 1);
            int temp;
            while (left < right) {
                temp = ar[left];
                ar[left] = ar[right];
                ar[right] = temp;
                left = left++;
                right = right--;
            }
        }
    }
}
