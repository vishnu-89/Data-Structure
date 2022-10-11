package com.geeks.ds.sorting;

import java.util.Arrays;

/**
 * Given the arrival and departure times of all trains that reach a railway station, the task is to find
 * the minimum number of platforms required for the railway station so that no train waits.
 */
public class MinimumPlatforms {
    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println("Minimum Number of Platforms Required : " + findPlatform(arr, dep, arr.length));
    }

    static int findPlatform(int arr[], int dep[], int n) {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 1;
        int result = 1;
        int i = 1;
        int j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            } else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }

            if (plat_needed > result) {
                result = plat_needed;
            }
        }

        return result;
    }
}
