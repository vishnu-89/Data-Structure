package com.geeks.ds.arrays;

/**
 * In a given array fine the majority element, the majority element is an element which occurs more than (n/2) times.
 */
public class MajorityElement {

    public static void main(String args[]) {
        int arr[] = {8, 8, 6, 6, 6, 4, 6}, n = 7;

        System.out.println(findMajority(arr, n));

    }

    private static int findMajority(int arr[], int n) {
        int res = 0;
        int count = 1;

        for(int i = 1; i < n; i++) {
            if(arr[res] == arr[i]) {
                count++;
            }
            else {
                count--;
            }

            if(count == 0) {
                res = i;
                count = 1;
            }
        }

        count = 0;

        for(int i = 0; i < n; i++) {
            if(arr[res] == arr[i]) {
                count++;
            }
        }

        if(count <= n /2) {
            res = -1;
        }

        return res;
    }

}
