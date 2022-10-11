package com.geeks.ds.arrays;

/**
 * Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array and return it
 * In other words, arrange the elements into a sequence such that arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....
 */
public class WaveArray {

    public static void main(String args[]) {

        int ar[] = {1,2,3,4,5,6};
        int len = ar.length;

        sortInWave(ar,len);
        for (int i : ar) {
            System.out.print(i + " ");
        }
    }

    private static void sortInWave(int ar[], int n) {

        for (int i=0; i<n-1; i += 2) {
            swap(ar, i, i+1);
        }
    }

    private static void swap(int ar[], int a, int b) {
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
    }
}
