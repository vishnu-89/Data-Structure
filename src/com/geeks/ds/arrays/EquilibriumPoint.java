package com.geeks.ds.arrays;

/**
 * Given an array A of n positive numbers. The task is to find the first Equilibium Point in the array.
 * Equilibrium Point in an array is a position such that the sum of elements before it is equal to the sum of elements after it.
 */
public class EquilibriumPoint {

    public static void main(String args[]) {

        int ar[] = {1,3,5,2,2};
        int len = ar.length;

        System.out.print("The equilibrium point " + equilibriumPoint(ar,len));

    }

    private static int equilibriumPoint(int a[], int n) {
        if(n == 1) {
            return 1;
        }

        int sum =0;
        for(int i =0; i <n; i++) {
            sum += a[i];
        }

        int left_sum =0;
        for(int i = 0; i < n; i++) {
            sum = sum - a[i];
            if(sum == left_sum) {
                return i + 1;
            }
            left_sum += a[i];
        }
        return -1;
    }
}
