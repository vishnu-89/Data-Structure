package com.geeks.ds.arrays;

public class LargestElementInArray {

    public static void main(String [] args) {
        int [] ar = {20, 10, 20, 4, 100};
        int len = ar.length;

        System.out.println("The largest element in an array : "+largestElement(ar,len));
    }

    private static int largestElement(int [] ar , int len) {
        int largest = ar[0];
        for(int i = 1 ; i < len ; i++) {
            if(largest < ar[i]) {
                largest = ar[i];
            }
        }
        return largest;
    }
}
