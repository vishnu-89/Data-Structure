package com.geeks.ds.arrays;

import java.util.Arrays;

/**
 * Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively
 * i.e first element should be max value, second should be min value, third should be second max,
 * fourth should be second min and so on.
 */
public class RearrangeArrayAlternately {

    public static void main(String[] args)
    {
        int ar[] =  { 1, 2, 3, 4, 5, 6 };

        System.out.println("Array before rearranging ");
        System.out.println(Arrays.toString(ar));

        rearrange(ar, ar.length);

        System.out.println("Array after rearranging ");
        System.out.println(Arrays.toString(ar));
    }

    private static void rearrange(int[] arr, int n) {

        int temp[] = arr.clone();

        int small = 0, large = n - 1;

        boolean flag = true;

        for (int i = 0; i < n; i++) {
            if (flag)
                arr[i] = temp[large--];
            else
                arr[i] = temp[small++];

            flag = !flag;
        }
    }

    //Solution 2 with extra space O(1)
    public static void rearrange1(int arr[], int n) {

        int max_idx = n - 1, min_idx = 0;

        int max_elem = arr[n - 1] + 1;

        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                arr[i] += (arr[max_idx] % max_elem) * max_elem;
                max_idx--;
            }
            else {
                arr[i] += (arr[min_idx] % max_elem) * max_elem;
                min_idx++;
            }
        }

        for (int i = 0; i < n; i++)
            arr[i] = arr[i] / max_elem;
    }

}
