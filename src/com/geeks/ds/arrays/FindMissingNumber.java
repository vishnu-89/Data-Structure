package com.geeks.ds.arrays;

/**
 * You are given an array of positive numbers from 1 to n, such that all numbers from 1 to n are present except one number x. You have to find x
 */
public class FindMissingNumber {

    public static void main(String[] args)
    {
        int[] ar = { 1, 2, 4, 5, 6 };
        System.out.println(findMissingNumber(ar, ar.length));
    }

    public static int findMissingNumber (int [] ar, int n) {

        int sum = ((n+1)*(n+2))/2;

        for(int i = 0 ; i < n ; i++) {
            sum = sum - ar[i];
        }

        return sum;
    }
}
