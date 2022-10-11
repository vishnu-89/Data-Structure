package com.geeks.ds.arrays;

/**
 * Given a sorted array find the frequency of each element
 */
public class FrequencyInSortedArray {

    public static void main(String [] args) {
        int [] ar = {10, 10, 20, 30, 30, 30};
        int len = ar.length;

        findFrequency(ar,len);
    }

    private static void findFrequency(int [] ar , int len) {
        int freq = 1;
        int i = 1;

        while(i < len) {
            while(i < len && ar[i] == ar[i - 1]) {
                freq++;
                i++;
            }
            System.out.println(ar[i - 1] + " " + freq);
            i++;
            freq = 1;
        }
    }
}
