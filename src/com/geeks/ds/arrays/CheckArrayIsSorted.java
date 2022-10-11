package com.geeks.ds.arrays;

public class CheckArrayIsSorted {
    public static void main(String [] args) {
        int [] ar = {4, 10, 20, 40, 100,200};
        int len = ar.length;

        System.out.println("Is array sorted : "+isArraySorted(ar,len));
    }

    private static boolean isArraySorted(int[] ar, int len) {
        for(int i = 0 ; i < len-1 ; i++) {
            if(ar[i] > ar[i+1] ) {
                return false;
            }

        }
        return true;
    }
}

