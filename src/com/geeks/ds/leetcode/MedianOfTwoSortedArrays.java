package com.geeks.ds.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfTwoSortedArrays {

    public static void main(String [] args) {
        int nums1[] = {1,1,1,1,1,1,1,1,1,1,4,4};
        int nums2[] = {1,3,4,4,4,4,4,4,4,4,4};

        double result  = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        while(i < n && j < m) {

            if( nums1[i] < nums2[j]) {
                list.add(nums1[i]);
                i++;
            }
            else if(nums1[i] > nums2[j]) {
                list.add(nums2[j]);
                j++;
            }
            else {
                list.add(nums2[j]);
                i++;
                j++;
            }
        }

        while( i < n) {
            list.add(nums1[i]);
            i++;
        }

        while( j < m) {
            list.add(nums2[j]);
            j++;
        }

        Collections.sort(list);
        int len = list.size();

        if(len % 2 == 0) {
            int z = len / 2;
            int e = list.get(z);
            int q = list.get(z-1);

            double ans = (double)(e + q) / 2;
            return ans;
        }
        else {
            int z = Math.round(len / 2);
            return list.get(z);
        }

    }
}
